package com.example.appreactiva.service;

import com.example.appreactiva.entity.Persona;
import com.example.appreactiva.repository.PersonaRepositoryHardCod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class ImpPersonasService implements IntPersonasService{

    @Autowired
    PersonaRepositoryHardCod personaRepository;

    @Override
    public Flux<Persona> getPersonas() {
        return personaRepository.getAll();
    }
}
