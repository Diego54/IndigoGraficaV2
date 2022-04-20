package com.indigoGrafica.service.impl;

import com.indigoGrafica.models.Person;
import com.indigoGrafica.repository.PersonRepository;
import com.indigoGrafica.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Pelotita on 30/3/2018.
 */

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    protected PersonRepository personRepository;

    @Override
    public Person save(Person person) {
        return personRepository.save(person);
    }

    @Override
    public List<Person> findAll() {
        return personRepository.findAll();
    }

    @Override
    public Person findByCuit(Long cuit) {
        return personRepository.findByCuit(cuit);
    }

    @Override
    public void delete(Person person) {
        personRepository.delete(person);
    }
}