package com.neogedom.professorvacancies.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.neogedom.professorvacancies.dto.CredenciaisDTO;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    private final AuthenticationManager authenticationManager;
    private final JWTUtil jwtUtil;

    public JWTAuthenticationFilter (AuthenticationManager authenticationManager, JWTUtil jwtUtil) {
        setAuthenticationFailureHandler(new JWTAuthenticationFailureHandler());
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }

    @SneakyThrows
    @Override
    public Authentication attemptAuthentication(@NotNull HttpServletRequest req,
                                                HttpServletResponse res)  throws AuthenticationException {
        CredenciaisDTO creds = new ObjectMapper()
                .readValue(req.getInputStream(), CredenciaisDTO.class);

        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(creds.getEmail(), creds.getSenha(), new ArrayList<>());
        return authenticationManager.authenticate(authToken);
    }

    @SneakyThrows
    @Override
    protected void successfulAuthentication (HttpServletRequest req, @NotNull HttpServletResponse res,
                                            FilterChain chain, @NotNull Authentication auth)  {
        String username = ((UserSS) auth.getPrincipal()).getUsername();
        String token = jwtUtil.generateToken(username);
        res.addHeader("Authorization", "Bearer " + token);
    }

    private static class JWTAuthenticationFailureHandler implements AuthenticationFailureHandler {

        @Override @SneakyThrows
        public void onAuthenticationFailure(HttpServletRequest req, @NotNull HttpServletResponse res, AuthenticationException exception) {
            res.setStatus(401);
            res.setContentType("application/json");
            res.getWriter().append(json());
        }

        private @NotNull String json () {
            return "{\"timestamp\": " + LocalDateTime.now() + ", "
                    + "\"status\": 401, "
                    + "\"error\": \"Não autorizado\", "
                    + "\"message\": \"Email ou senha inválidos\", "
                    + "\"path\": \"/login\"}";
        }
    }
}
