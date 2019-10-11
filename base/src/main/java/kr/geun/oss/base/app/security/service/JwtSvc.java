package kr.geun.oss.base.app.security.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.stream.Collectors;

/**
 * JwtSvc
 *
 * @author akageun
 * @since 2019-10-11
 */
@Slf4j
@Service
public class JwtSvc {
    private static final String SECRET_KEY = "12345";

    public static final String JWT_PREFIX = "Bearer ";
    private static final String AUTHORITIES_KEY_NM = "auth";
    private static final long TOKEN_EXPIRE_MS = 3600 * 1000; //1Hours
    private static final String TOKEN_CREATED_AT = "tca";

    public String generate(Authentication authentication) {
        String authorities = authentication.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.joining(","));

        Date expireDate = new Date(System.currentTimeMillis() + TOKEN_EXPIRE_MS);
        return Jwts.builder()
            .setSubject(authentication.getName())
            .claim(AUTHORITIES_KEY_NM, authorities)
            .claim(TOKEN_CREATED_AT, new Date())
            .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
            .setExpiration(expireDate)
            .compact();
    }

}
