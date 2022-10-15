package com.example.appreactiva.repository;

import com.example.appreactiva.entity.Persona;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PersonasRepository extends R2dbcRepository<Persona, Integer> {

    @Query(value = "" +
            "SELECT\n" +
            "   *\n" +
            "FROM\n" +
            "   personas2\n")
    Flux<Persona> getAll();

    @Query(value = ""+
            "SELECT\n" +
            "   *\n" +
            "FROM\n" +
            "   personas2\n" +
            "WHERE\n" +
            "   documento = :doc\n")
    Mono<Persona> getByDocumento(int doc);

    @Query(value = "" +
            "INSERT\n" +
            "INTO\n" +
            "   personas2\n" +
            "(documento, nombre, apellido, edad)\n" +
            "VALUES\n" +
            "(:doc , :nom , :ape , :edad )\n")
    Mono<Persona> addPersona(int doc, String nom, String ape, int edad);

    @Query(value = "" +
            "DELETE\n" +
            "FROM\n" +
            "   personas2\n" +
            "WHERE\n" +
            "   documento = :doc\n")
    Mono<Void> deleteByDocumento(int doc);

}
