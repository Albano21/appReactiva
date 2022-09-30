package com.example.appreactiva.repository;

import com.example.appreactiva.entity.Persona;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.util.ArrayList;

@Repository
public class PersonaRepositoryHardCod {

    public Flux<Persona> getAll(){

        Persona persona1 = new Persona(3661975, "Jorge", "Perez", 65);
        Persona persona2 = new Persona(3561456, "Raul", "Lopez", 25);
        Persona persona3 = new Persona(4561975, "Marina", "Juarez", 48);

        ArrayList<Persona> personas = new ArrayList<>();
        personas.add(persona1);
        personas.add(persona2);
        personas.add(persona3);

        return Flux.fromIterable(personas);
    }
}
