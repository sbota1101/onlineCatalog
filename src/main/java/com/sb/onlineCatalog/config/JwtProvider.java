package com.sb.onlineCatalog.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import static org.springframework.security.core.userdetails.User.withUsername;
import java.util.Base64;
import java.util.Date;
@Component
public class JwtProvider {
    private String secretKey;
    private long validityInMiliseconds;

    @Autowired
    public JwtProvider(@Value("${security.jwt.token.secret-key}") String secretKey,
                       @Value("${security.jwt.token.expiration}") long validityInMiliseconds) {
        this.secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
        this.validityInMiliseconds = validityInMiliseconds;
    }

    public String createToken(String username) {
        Claims claims = Jwts.claims().setSubject(username);
        Date now = new Date();
        Date expiresAt = new Date(now.getTime() + validityInMiliseconds);
        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(expiresAt)
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }
    public boolean isTokenValid(String jwtToken) {
        try {
            Jwts.parser().setSigningKey(secretKey).parseClaimsJws(jwtToken);
            return true;
        } catch (JwtException e) {
            return false;
        }
    }
    public String getUsername(String jwtToken){
        return Jwts.parser().setSigningKey(secretKey)
                .parseClaimsJws(jwtToken).getSignature();
    }
}
