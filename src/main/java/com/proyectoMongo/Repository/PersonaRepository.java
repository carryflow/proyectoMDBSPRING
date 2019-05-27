package com.proyectoMongo.Repository;

import com.proyectoMongo.Documentos.Persona;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PersonaRepository extends MongoRepository<Persona, String> {

    public Persona findByid(String idPersona);
}
