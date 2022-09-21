package com.infozup.cadastrocliente.domain.service;


import com.infozup.cadastrocliente.domain.entity.Person;
import com.infozup.cadastrocliente.domain.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public Person savePerson(Person person){
        return personRepository.save(person);
    }

    public List<Person> findAll() {
        return  personRepository.findAll();
    }
}