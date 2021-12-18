package com.neogedom.professorvacancies.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.Date;

@Component
public class JWTUtil {

    @Value("${jwt.secret}")
    @Getter private String secret;

    @Value("${jwt.expiration}")
    @Getter private Long expiration;

    public String generateToken(String username) {
        var date = new Date(System.currentTimeMillis() + expiration);
        return JWT.create()
               .withSubject(username)
               .withExpiresAt(new Date(System.currentTimeMillis() + expiration))
               .sign(Algorithm.HMAC512(secret.getBytes(StandardCharsets.UTF_8)));
    }

}
