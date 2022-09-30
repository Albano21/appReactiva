package com.example.appreactiva.service;

import com.example.appreactiva.entity.Persona;
import reactor.core.publisher.Flux;

public interface IntPersonasService {

    Flux<Persona> getPersonas();
}
