package org.example.admin.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import java.util.Map;

public class jwtUtils {

    private static String signKey="Edith";
    private static long expire=43200000L;


    public static String generateToken(Map<String, Object> claims) {
        String token = Jwts.builder()
                .addClaims(claims)
                .signWith(SignatureAlgorithm.HS256,signKey)
                .setExpiration(new Date(System.currentTimeMillis()+expire))
                .compact();
        return token;
    }

    public static Map<String, Object> parseToken(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(signKey)
                .parseClaimsJws(token)
                .getBody();
        return claims;
    }
}
