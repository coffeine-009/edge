package com.thecoffeine.edge;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

/**
 * Edge server.
 * Netflix Zuul.
 *
 * @version 1.0
 */
@SpringBootApplication
@EnableOAuth2Sso
@EnableZuulProxy
public class EdgeApplication extends WebSecurityConfigurerAdapter {

    public static void main( String [] args ) {
        new SpringApplicationBuilder( EdgeApplication.class )
            .web( true )
            .run( args );
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        // @formatter:off
        http
            .logout().and()
            .authorizeRequests()
            .antMatchers( "/", "/music/songs/*", "/api/music/songs/*", "/login" ).permitAll()
            .anyRequest().authenticated()
            .and()
            .csrf()
            .csrfTokenRepository( CookieCsrfTokenRepository.withHttpOnlyFalse());
        // @formatter:on
    }
}
