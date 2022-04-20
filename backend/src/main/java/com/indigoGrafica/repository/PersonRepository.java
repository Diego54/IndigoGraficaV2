package com.indigoGrafica.repository;

import com.indigoGrafica.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


/**
 * Created by Pelotita on 30/3/2018.
 */
public interface PersonRepository extends JpaRepository<Person,Integer> {

    Person save(Person person);
    Person findByCuit(Long cuit);

}
