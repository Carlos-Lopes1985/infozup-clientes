package com.infozup.cadastrocliente.controller;

import com.infozup.cadastrocliente.domain.entity.Person;
import com.infozup.cadastrocliente.domain.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value="/pessoas")
public class PersonController {

    private static final Logger log = LoggerFactory.getLogger(PersonController.class);

    @Autowired
    private PersonService personService;


    /**
     * Responsável por retornar todas as pessoas cadastrdas
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Person>> findAll()throws Exception{

        log.info("Buscando todas as pessoas {}.");

        return ResponseEntity.ok().body(personService.findAll());
    }

    /**
     * Responsável por inserir pessoas na base de dados
     *
     * @param obj
     * @return
     * @throws Exception
     */
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insert( @RequestBody Person obj) throws Exception{

        log.info("Inserindo pessoas:", obj.getId());

        Person person = personService.savePerson(obj);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }
}
