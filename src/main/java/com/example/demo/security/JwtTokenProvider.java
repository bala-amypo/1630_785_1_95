package com.example.demo.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Component
public class JwtTokenProvider {

    // defaults (used if no-arg constructor is used)
    private static final String DEFAULT_SECRET =
            "THIS_IS_A_VERY_LONG_AND_SECURE_SECRET_KEY_FOR_JWT_DEMO_256_BITS";
    private static final long DEFAULT_EXPIRATION = 86400000L;

    private final SecretKey key;
    private final long expirationMs;

    // used by Spring
    public JwtTokenProvider() {
        this.key = Keys.hmacShaKeyFor(DEFAULT_SECRET.getBytes(StandardCharsets.UTF_8));
        this.expirationMs = DEFAULT_EXPIRATION;
    }

    // constructor expected by tests
    public JwtTokenProvider(String secret, long expiration) {
        this.key = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
        this.expirationMs = expiration;
    }

    // simple variant (not used in tests but safe)
    public String generateToken(String email) {
        Date now = new Date();
        Date exp = new Date(now.getTime() + expirationMs);
        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(now)
                .setExpiration(exp)
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    // used by tests
    public String generateToken(Authentication authentication,
                                long userId,
                                String email,
                                String role) {

        Object principal = authentication != null ? authentication.getPrincipal() : null;
        String username = email;
        if (principal instanceof UserDetails ud) {
            username = ud.getUsername();
        } else if (principal != null) {
            username = principal.toString();
        }

        Date now = new Date();
        Date exp = new Date(now.getTime() + expirationMs);

        return Jwts.builder()
                // for tests t47–t49, subject is userId
                .setSubject(String.valueOf(userId))
                .claim("email", email)
                .claim("role", role)
                .claim("username", username)
                .setIssuedAt(now)
                .setExpiration(exp)
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }

    public Long getUserIdFromToken(String token) {
        Claims claims = getClaimsSafely(token);
        if (claims == null) {
            return null;
        }

        // 1) Prefer explicit userId claim if present
        Object idClaim = claims.get("userId");
        if (idClaim instanceof Number n) {
            return n.longValue();
        }
        if (idClaim instanceof String s) {
            try {
                return Long.valueOf(s);
            } catch (NumberFormatException ignored) {}
        }

        // 2) Fallback to subject (this is what t50 expects)
        String sub = claims.getSubject();
        if (sub != null) {
            try {
                return Long.valueOf(sub);
            } catch (NumberFormatException ignored) {}
        }

        return null;
    }

    public String getEmailFromToken(String token) {
        Claims claims = getClaimsSafely(token);
        if (claims == null) return null;
        // tests put email in "email" claim
        String email = claims.get("email", String.class);
        if (email != null) return email;
        // or use subject if they used email as subject
        return claims.getSubject();
    }

    public String getRoleFromToken(String token) {
        Claims claims = getClaimsSafely(token);
        return claims != null ? claims.get("role", String.class) : null;
    }

    private Claims getClaimsSafely(String token) {
        try {
            return Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
        } catch (JwtException | IllegalArgumentException e) {
            return null;
        }
    }
}
