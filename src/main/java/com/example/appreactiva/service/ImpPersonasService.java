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

    @Override
    public Mono<Persona> addPersona(Persona p) {
        return personasRepository.addPersona(p.getDocumento(), p.getNombre(), p.getApellido(), p.getEdad());
    }

    @Override
    public Mono<Void> deleteByDocumento(int documento) {
        return personasRepository.deleteByDocumento(documento);
    }



    /*
    @Override
    public Mono<Persona> addPersona(int doc, Persona p){
        String respuesta = "";
        //Persona p = personaMono.toFuture().getNow(null);
        Mono<Persona> personaExistente = personasRepository.getByDocumento(doc);

        if(personaExistente == null){
            personasRepository.addPersona(p.getDocumento(), p.getNombre(), p.getApellido(), p.getEdad());
            return Mono.just(p);

        }
        else{
            return personaExistente;
        }


    }

     */

}
