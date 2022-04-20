package com.indigoGrafica.service;

import com.indigoGrafica.models.Person;

import java.util.List;

/**
 * Created by Pelotita on 30/3/2018.
 */
public interface PersonService {
    Person save(Person person);
    List<Person> findAll();
    Person findByCuit(Long cuit);
    void delete(Person person);
}
