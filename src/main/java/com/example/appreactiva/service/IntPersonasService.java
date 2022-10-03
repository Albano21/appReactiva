package com.example.appreactiva.service;

import com.example.appreactiva.entity.Persona;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IntPersonasService {

    Flux<Persona> getPersonas();

    Mono<Persona> getByDocumento(int doc);
}
