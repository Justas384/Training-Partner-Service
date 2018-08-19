package com.justas.trainingpartner.security;

import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JWTTokenProvider {
    private static final Logger logger = LoggerFactory.getLogger(JWTTokenProvider.class);

    @Value("${app.jwtSecret}")
    private String jwtSecret;

    @Value("${app.jwtExpirationInMs}")
    private int jwtExpirationInMs;

    public String generateToken(Authentication authentication) {
        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();

        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + jwtExpirationInMs);

        return Jwts.builder()
                .setSubject(Integer.toString(userPrincipal.getId()))
                .setIssuedAt(new Date())
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }

    public boolean validateToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);

            return true;
        } catch (SignatureException signatureException) {
            logger.error("Invalid JWT signature.");
        } catch (MalformedJwtException malformedJwtException) {
            logger.error("Invalid JWT token.");
        } catch (ExpiredJwtException expiredJwtException) {
            logger.error("Expired JWT token.");
        } catch (UnsupportedJwtException unsupportedJwtException) {
            logger.error("Unsupported JWT token.");
        } catch (IllegalArgumentException illegalArgumentException) {
            logger.error("JWT claims string is empty.");
        }

        return false;
    }

    public int getUserIdFromJwt(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(jwtSecret)
                .parseClaimsJws(token)
                .getBody();

        return Integer.parseInt(claims.getSubject());
    }
}