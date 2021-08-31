package com.everis.bootcamp.ms.monedero.router;

import com.everis.bootcamp.ms.monedero.handler.MonederoTransactionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class RouterFuntionConfig {

    @Bean
    public RouterFunction<ServerResponse> routes (MonederoTransactionHandler handler) {
        return route(GET("/monederoTransaction"), handler::findAll)
                .andRoute(GET("/monederoTransaction/{id}"), handler::findId)
                .andRoute(POST("/monederoTransaction"),handler::create);
    }

}
