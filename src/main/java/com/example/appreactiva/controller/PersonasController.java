package com.example.appreactiva.controller;

import com.example.appreactiva.entity.Persona;
import com.example.appreactiva.service.IntPersonasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;

@Configuration
public class PersonasController {

    @Autowired
    private IntPersonasService intPersonasService;

    @Bean
    public RouterFunction<ServerResponse> routeBoxes() {
        return RouterFunctions.route(RequestPredicates.GET("/personas"), request -> {
            Flux<Persona> heartbeatEntityFlux = intPersonasService.getPersonas();
            return ServerResponse
                    .ok()
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(heartbeatEntityFlux, Persona.class);
        });
    }


}
