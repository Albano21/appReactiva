package com.example.appreactiva.service;

import com.example.appreactiva.entity.Persona;
import com.example.appreactiva.repository.PersonasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ImpPersonasService implements IntPersonasService{

    @Autowired
    PersonasRepository personasRepository;

    @Override
    public Flux<Persona> getPersonas() {
        return personasRepository.getAll();
    }

    @Override
    public Mono<Persona> getByDocumento(int doc) {
        return personasRepository.getByDocumento(doc);
    }
}
