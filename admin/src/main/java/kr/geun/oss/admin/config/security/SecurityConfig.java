package kr.geun.oss.admin.config.security;

import kr.geun.oss.admin.config.filter.JwtAuthenticationFilter;
import kr.geun.oss.admin.config.security.service.AcUserDetailsService;
import kr.geun.oss.admin.config.security.service.JwtSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletResponse;

/**
 * SecurityConfig
 *
 * @author akageun
 * @since 2019-10-14
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AcUserDetailsService acUserDetailsService;

    @Autowired
    private JwtSvc jwtSvc;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //@formatter:off
		http
			.addFilterBefore(new JwtAuthenticationFilter(jwtSvc),
					UsernamePasswordAuthenticationFilter.class)
			.cors()
			.and()
			.csrf()
				.disable()
			.authorizeRequests()
				.antMatchers("/h2-console/**").permitAll()
				.antMatchers(HttpMethod.POST, "/api/user/**")
					.permitAll()

				.antMatchers("/api/bbs/**")
					.hasAnyRole("ROLE_USER", "ROLE_ADMIN")
				.antMatchers("/api/admin/**")
					.hasAnyRole("ROLE_ADMIN")
			.anyRequest()
				.permitAll()
			.and()
				.headers().frameOptions().disable()
			.and()
				.exceptionHandling()
					.authenticationEntryPoint((req, rsp, e) -> rsp.sendError(HttpServletResponse.SC_UNAUTHORIZED)) ;
		//@formatter:on

        //super.configure(http);
    }

    /**
     * 패스워드 암호화
     *
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected UserDetailsService userDetailsService() {
        return acUserDetailsService;
    }
}
