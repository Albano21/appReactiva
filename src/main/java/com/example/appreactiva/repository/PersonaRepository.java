package com.example.appreactiva.repository;

import com.example.appreactiva.entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import reactor.core.publisher.Flux;

public interface PersonaRepository extends JpaRepository<Persona, Integer> {

    Flux<Persona> getAll();
}
