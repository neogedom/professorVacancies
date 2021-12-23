package com.neogedom.professorvacancies.config;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest req, HttpServletResponse res, AuthenticationException authException) throws IOException {
        res.setContentType("application/json;charset=UTF-8");
        res.setStatus(403);
        res.setContentType("application/json");
        res.getWriter().append(json(req));
    }

    private String json (HttpServletRequest req) {
        return "{\"timestamp\": " + LocalDateTime.now() + ", "
                + "\"status\": 403, "
                + "\"error\": \"Não autorizado\", "
                + "\"message\": \"Este usuário não pode acessar esse recurso\" } ";
    }
}