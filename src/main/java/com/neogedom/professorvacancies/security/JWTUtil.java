package com.neogedom.professorvacancies.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.Date;

// https://javatodev.com/spring-boot-jwt-authentication/#f39ca81c2016

@Component
public class JWTUtil {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private Long expiration;

    public String generateToken(String username) {
        return JWT.create()
               .withSubject(username)
               .withExpiresAt(new Date(System.currentTimeMillis() + expiration))
               .sign(Algorithm.HMAC512(secret.getBytes(StandardCharsets.UTF_8)));
    }
}
