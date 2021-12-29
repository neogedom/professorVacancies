package com.neogedom.professorvacancies.resources;

import com.neogedom.professorvacancies.domain.Usuario;
import com.neogedom.professorvacancies.security.JWTUtil;
import com.neogedom.professorvacancies.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(value = "/auth")
public class AuthResource {

    private final UsuarioService usuarioService;
    private final JWTUtil jwtUtil;

    public AuthResource(UsuarioService usuarioService, JWTUtil jwtUtil) {
        this.usuarioService = usuarioService;
        this.jwtUtil = jwtUtil;
    }

    @RequestMapping(value = "refresh_token")
    public ResponseEntity<Void> refreshToken(HttpServletResponse response) {
        Usuario usuario = usuarioService.authenticated();
        String token = jwtUtil.generateToken(usuario.getEmail());
        response.addHeader("Authorization", "Bearer " + token);
        return ResponseEntity.noContent().build();
    }
}
