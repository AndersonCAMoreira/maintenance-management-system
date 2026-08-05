package com.anderson.backend.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;

@Service
public class JwtService {

    private final SecretKey chave = Keys.hmacShaKeyFor(System.getenv("JWT_SECRET").getBytes());
    private final long validadeMs = 1000 * 60 * 60 * 8; // 8 horas

    public String gerarToken(String login) {
        Date agora = new Date();
        Date expiracao = new Date(agora.getTime() + validadeMs);

        return Jwts.builder()
            .subject(login)
            .issuedAt(agora)
            .expiration(expiracao)
            .signWith(chave)
            .compact();
    }

    public String extrairLogin(String token) {
        return Jwts.parser()
            .verifyWith(chave)
            .build()
            .parseSignedClaims(token)
            .getPayload()
            .getSubject();
    }

}