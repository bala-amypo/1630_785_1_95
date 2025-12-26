package com.example.demo.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.Authentication;

import java.security.Key;
import java.util.Date;

public class JwtTokenProvider {

    private final Key key;
    private final long validityInMs;

    public JwtTokenProvider(String secret, long validityInMs) {
        this.key = Keys.hmacShaKeyFor(secret.getBytes());
        this.validityInMs = validityInMs;
    }

    public String generateToken(Authentication authentication,
                                Long userId,
                                String email,
                                String role) {
        Date now = new Date();
        Date expiry = new Date(now.getTime() + validityInMs);

        return Jwts.builder()
                .setSubject(String.valueOf(userId))
                .claim("uid", userId)
                .claim("email", email)
                .claim("role", role)
                .setIssuedAt(now)
                .setExpiration(expiry)
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    public Long getUserIdFromToken(String token) {
        Claims claims = parseClaims(token);
        Object uid = claims.get("uid");
        if (uid != null) {
            return Long.valueOf(uid.toString());
        }
        // Fallback to subject (t50)
        String sub = claims.getSubject();
        return sub != null ? Long.valueOf(sub) : null;
    }

    public String getEmailFromToken(String token) {
        Claims claims = parseClaims(token);
        Object email = claims.get("email");
        return email != null ? email.toString() : null;
    }

    public String getRoleFromToken(String token) {
        Claims claims = parseClaims(token);
        Object role = claims.get("role");
        return role != null ? role.toString() : null;
    }

    public boolean validateToken(String token) {
        try {
            parseClaims(token);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }

    private Claims parseClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}
