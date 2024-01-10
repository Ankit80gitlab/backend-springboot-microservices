package com.cms.apigateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class APIConfig {

    @Bean
    public RouteLocator routing(RouteLocatorBuilder rlb){
        return rlb.routes().
                route(i->
                        i.path("/app/auth/**").
                                uri("http://localhost:8082/*")).
                        route(p->
                        p.path("/app/emp/**").
                                uri("http://localhost:8085/*")).
                        build();
    }


}
