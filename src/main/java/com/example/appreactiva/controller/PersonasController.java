package com.example.appreactiva.controller;

import com.example.appreactiva.entity.Persona;
import com.example.appreactiva.service.IntPersonasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.reactive.function.server.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.BodyExtractors.toMono;

@Configuration
public class PersonasController {

    @Autowired
    private IntPersonasService intPersonasService;

    @Bean
    public RouterFunction<ServerResponse> routeAll() {
        return RouterFunctions.route(RequestPredicates.GET("/personas"), request -> {
            Flux<Persona> result = intPersonasService.getPersonas();
            return ServerResponse
                    .ok()
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(result, Persona.class);
        });
    }

    @Bean
    public RouterFunction<ServerResponse> routeByDoc() {
        return RouterFunctions.route(RequestPredicates.GET("/personas/{doc}"), request -> {
            Mono<Persona> result = intPersonasService.getByDocumento(Integer.parseInt(request.pathVariable("doc")));
            return ServerResponse
                    .ok()
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(result, Persona.class);
        });
    }

    @Bean
    public RouterFunction<ServerResponse> createPersona() {
        return RouterFunctions.route()
                .POST("/personas/guardar/", request -> request.bodyToMono(Persona.class)
                        .flatMap(intPersonasService::addPersona)
                        .flatMap(persona -> ServerResponse
                                .status(HttpStatus.CREATED)
                                .body(persona, Persona.class))).build();
    }

    @Bean
    public RouterFunction<ServerResponse> deletePersona() {
        return RouterFunctions.route()
                .DELETE("/personas/borrar/{doc}", request -> {
                    int doc = Integer.parseInt(request.pathVariable("doc"));
                    return ServerResponse.ok().body(intPersonasService.deleteByDocumento(doc), Void.class);
                }).build();
    }


    /*
    @Bean
    public RouterFunction<ServerResponse> routeGuardar() {
        return RouterFunctions.route(RequestPredicates.POST("/personas/guardar/{doc}"),
                request -> {
                    int doc = Integer.parseInt(request.pathVariable("doc"));
                    Mono<Persona> personaMono = request.body(toMono(Persona.class));
                    String result = intPersonasService.addPersona(doc, personaMono);
                    return ServerResponse
                            .ok()
                            .contentType(MediaType.APPLICATION_JSON)
                            .body(result, String.class);
                }
        );
    }

     */





}
