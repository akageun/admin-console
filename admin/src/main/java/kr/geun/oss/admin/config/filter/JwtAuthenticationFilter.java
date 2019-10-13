package kr.geun.oss.admin.config.filter;

import io.jsonwebtoken.ExpiredJwtException;
import kr.geun.oss.base.app.security.service.JwtSvc;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author akageun
 */
@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class JwtAuthenticationFilter extends GenericFilterBean {

    private JwtSvc jwtSvc;

    public JwtAuthenticationFilter(JwtSvc jwtSvc) {
        this.jwtSvc = jwtSvc;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws
        IOException,
        ServletException {
        try {
            HttpServletRequest request = (HttpServletRequest) servletRequest;

            Authentication authentication = jwtSvc.getAuthentication(request.getHeader(JwtSvc.JWT_HEADER_STRING));

            if (authentication != null) {
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }

        } catch (ExpiredJwtException e) {
            log.error("e : {}, {}", e.getMessage(), e);
            SecurityContextHolder.clearContext();
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }
}
