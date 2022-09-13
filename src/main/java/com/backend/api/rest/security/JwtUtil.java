/* PRODUCT : api.rest
 * PROJECT : api.rest
 * PACKAGE : com.backend.api.rest.security
 * ***********************************************************************************
 *
 * Copyright(C) 2021
 *
 *
 *
 * **************************************************************************************
 *
 * REVISIONS:
 * Author : Mic_Gihan Perera
 * Date : 8/29/2022 - 12:07 PM
 * Since : version 1.0
 * Description :
 * ****************** */
package com.backend.api.rest.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * jwt filtering class
 * Author : Mic_Gihan Perera
 * Date : 8/29/2022 - 12:07 PM
 */
@Component
public class JwtUtil {

    /* string attribute creation */
    private String secret = "rambase";

    /* Username related details */
    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    /* Username Expiration details */
    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    /* support function details */
    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }
    /* support function details regarding token */
    private Claims extractAllClaims(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }
    /* support function details regarding token */
    private Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    /* support function details regarding token generation */
    public String generateToken(String username) {
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, username);
    }

    /* support function details regarding token creation and expiration */
    private String createToken(Map<String, Object> claims, String subject) {

        return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 5))
                .signWith(SignatureAlgorithm.HS256, secret).compact();
    }

    /* support function details regarding token validation */
    public Boolean validateToken(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }
}
