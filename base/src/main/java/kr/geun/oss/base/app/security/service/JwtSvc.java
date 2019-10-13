package kr.geun.oss.base.app.security.service;

import io.jsonwebtoken.ClaimJwtException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
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

    public static final String JWT_HEADER_STRING = "Authorization";

    public static final String JWT_PREFIX = "Bearer ";
    private static final String AUTHORITIES_KEY_NM = "auth";
    private static final long TOKEN_EXPIRE_MS = 3600 * 1000; //1Hours
    private static final String TOKEN_CREATED_AT = "tca";

    public String generate(Authentication authentication) {

        String authorities = authentication
            .getAuthorities()
            .stream()
            .map(GrantedAuthority::getAuthority)
            .collect(Collectors.joining(","));

        Date expireDate = new Date(System.currentTimeMillis() + TOKEN_EXPIRE_MS);
        return Jwts.builder()
            .setSubject(authentication.getName())
            .claim(AUTHORITIES_KEY_NM, authorities)
            .claim(TOKEN_CREATED_AT, new Date())
            .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
            .setExpiration(expireDate)
            .compact();
    }

    public Authentication getAuthentication(String fullToken) {
        if (StringUtils.isBlank(fullToken)) {
            return null;
        }

        String jwt = StringUtils.replace(fullToken, JWT_PREFIX, "");
        if (StringUtils.isBlank(jwt)) {
            return null;
        }

        Claims claims = getJwtClaims(jwt);
        if (claims == null) {
            return null;
        }

        String userId = claims.getSubject();

        if (claims.getExpiration().before(new Date())) {
            return null;
        }

        String authoritiesStr = claims.get(AUTHORITIES_KEY_NM).toString();


        Collection<? extends GrantedAuthority> authorities = Arrays.asList(authoritiesStr.split(","))
            .stream()
            .map(SimpleGrantedAuthority::new)
            .collect(Collectors.toList());

        return new UsernamePasswordAuthenticationToken(userId, null, authorities);
    }

    private Claims getJwtClaims(String token) throws ClaimJwtException {
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
    }
}
