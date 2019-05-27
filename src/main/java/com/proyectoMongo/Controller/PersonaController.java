package com.proyectoMongo.Controller;

import com.proyectoMongo.Documentos.Persona;
import com.proyectoMongo.Repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class PersonaController {

    @Autowired
    private PersonaRepository personaRepository;

    @GetMapping("/personas")
    public List<Persona> getAllPersonas(){
        return personaRepository.findAll();
    }

    @GetMapping("/personas/{idPersona}")
    public Persona getPersonaById(@PathVariable("idPersona") String idPersona){
        return personaRepository.findByid(idPersona);
    }

    @PutMapping("/personas/{idPersona}")
    public void modifyPersonaById(@PathVariable("idPersona") String idPersona, @Valid @RequestBody Persona persona){
        persona.setId(idPersona);
        personaRepository.save(persona);
    }

    @PostMapping("/personas")
    public Persona createPersona(@Valid @RequestBody Persona persona){
        return personaRepository.save(persona);
    }

    @DeleteMapping("/personas/{idPersona}")
    public void deletePersona(@PathVariable String idPersona){
        personaRepository.delete(personaRepository.findByid(idPersona));
    }

}
