package com.thecoffeine.edge;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * Edge server.
 * Netflix Zuul.
 *
 * @version 1.0
 */
@SpringBootApplication
@EnableZuulProxy
@EnableOAuth2Sso
public class EdgeApplication {

    public static void main( String [] args ) {
        new SpringApplicationBuilder( EdgeApplication.class )
            .web( true )
            .run( args );
    }
}
