package com.yurigb.luabank.service;

import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {

    @Value("${CHAVE_PRIVADA}")
    private String SECRET_KEY;

    private final SecretKey key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());

    public String gerarToken(String email) {

        return Jwts.builder()
                .subject(email)
                .issuedAt(new Date())
                .expiration(
                        new Date(System.currentTimeMillis()
                                + 1000 * 60 * 60 * 24))
                .signWith(key)
                .compact();
    }

    public String extrairEmail(String token) {

        return Jwts.parser()
                .verifyWith(key)
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();
    }

    public boolean validarToken(String token, String email) {
        try {
            String emailDoToken = extrairEmail(token);
            return emailDoToken.equals(email);
        } catch (Exception e) {
            return false;
        }
    }
}