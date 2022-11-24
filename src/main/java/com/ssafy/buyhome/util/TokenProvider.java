package com.ssafy.buyhome.util;

import com.ssafy.buyhome.user.model.dto.Token;
import com.ssafy.buyhome.user.model.exception.UserUnauthorizedException;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Date;

@Component
public class TokenProvider {
    private static final String AUTHORITY_KEY = "authority";
    private final String secretForAccess = "2646294A404E635266556A576E5A7234753778214125442A472D4B6150645367";
    private final Key accessKey;
    private final int ACCESS_TOKEN_EXPIRE_MINUTES = 30;

    public TokenProvider() {
        this.accessKey = Keys.hmacShaKeyFor(Decoders.BASE64.decode(secretForAccess));
    }

    public Token createToken(String username, String authority) {
        LocalDateTime accessTokenValidTime =
                LocalDateTime.now().plusMinutes(ACCESS_TOKEN_EXPIRE_MINUTES);

        String accessToken = Jwts.builder()
                .setSubject(username)
                .claim(AUTHORITY_KEY, authority)
                .setExpiration(Date.from(accessTokenValidTime.toInstant(ZoneOffset.UTC)))
                .signWith(accessKey, SignatureAlgorithm.HS256)
                .compact();

        return new Token(accessToken);
    }

    public boolean validateAccessToken(String token) {
        Jws<Claims> claimsJws = Jwts.parserBuilder().setSigningKey(accessKey).build().parseClaimsJws(token);
        Date now = Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant());
        return claimsJws.getBody()
                .getExpiration()
                .after(now);

    }

    public String getUsernameFromToken(String token) {
        try {
            Jws<Claims> claimsJws = Jwts.parserBuilder().setSigningKey(accessKey).build().parseClaimsJws(token);
            return claimsJws.getBody().getSubject();
        } catch (Exception e) {
            throw new UserUnauthorizedException();
        }
    }
}
