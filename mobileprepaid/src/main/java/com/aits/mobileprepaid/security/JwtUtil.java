package com.aits.mobileprepaid.security;
import java.util.Date;
import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

@Component
public class JwtUtil {

    private static final String SECRET = "mySecretKeymySecretKeymySecretKeymySecretKey"; // Must be 32+ chars
    private static final SecretKey SECRET_KEY = Keys.hmacShaKeyFor(SECRET.getBytes(StandardCharsets.UTF_8));

    // 🔹 Generate JWT Token
    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username) // ✅ setSubject, not .subject()
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60)) // 1 hour
                .signWith(SECRET_KEY, SignatureAlgorithm.HS256) // ✅ SignatureAlgorithm is required
                .compact();
    }

    // 🔹 Validate JWT Token
    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(SECRET_KEY)
                    .build()
                    .parseClaimsJws(token); // ✅ parseClaimsJws for full token (header + signature)
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // 🔹 Extract Username from Token
    public String extractUsername(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(SECRET_KEY)
                .build()
                .parseClaimsJws(token)
                .getBody(); // ✅ getBody() for Claims
        return claims.getSubject();
    }
}