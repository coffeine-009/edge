package com.thecoffeine.edge;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.stereotype.Controller;

/**
 * Edge server.
 * Netflix Zuul.
 *
 * @version 1.0
 */
@SpringBootApplication
@Controller
@EnableZuulProxy
public class EdgeApplication {

    public static void main( String [] args ) {
        new SpringApplicationBuilder( EdgeApplication.class )
            .web( true )
            .run( args );
    }
}
