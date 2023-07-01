package com.sistema.encuestas.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TokenMaker {

    //BASE64 ENCODE
    private final static String ACCESS_TOKEN_SECRET = "bmVvcmlzLWFsZXhpcw==";
    private final static Long ACCESS_TOKEN_TIMEOUT = 3_600L;


    public static String createToken(String name, String email){
        long expirationTime = ACCESS_TOKEN_TIMEOUT * 1_000;
        var expirationDate = new Date(System.currentTimeMillis() + expirationTime);

        Map <String, Object> paramExtra = new HashMap<>();
        paramExtra.put("nombre", name);

        return Jwts.builder()
                .setSubject(email)
                .setExpiration(expirationDate)
                .addClaims(paramExtra)
                .signWith(Keys.hmacShaKeyFor(ACCESS_TOKEN_SECRET.getBytes()))
                .compact();
    }

    public static UsernamePasswordAuthenticationToken getAuth(String token){
        try {
            Claims claims = Jwts.parserBuilder()
                    .setSigningKey(ACCESS_TOKEN_SECRET.getBytes())
                    .build()
                    .parseClaimsJws(token)
                    .getBody();

            String email = claims.getSubject();

            return new UsernamePasswordAuthenticationToken(email, null, Collections.emptyList());
        } catch (JwtException e ){
            return null;
        }
    }


}
