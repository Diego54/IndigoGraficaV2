package com.indigoGrafica.controllers;

import com.indigoGrafica.models.Person;
import com.indigoGrafica.service.PersonService;
import com.indigoGrafica.util.RestResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.io.IOException;
import java.util.List;

@RestController
public class PersonController {

    @Autowired
    protected PersonService personService;

    @Inject
    protected ObjectMapper objectMapper;

    @RequestMapping(value = "/person/saveOrUpdate", method = RequestMethod.POST)
    public RestResponse saveOrUpdate(@RequestBody String personJson) throws IOException {
        Person person = objectMapper.readValue(personJson,Person.class);
        personService.save(person);
        return new RestResponse(HttpStatus.OK.value(),"Operacion Exitosa");
    }

    @RequestMapping(value = "/person/getAll",method = RequestMethod.GET)
    public List<Person> getAll(){
        return personService.findAll();
    }

    @RequestMapping(value = "/person/delete", method = RequestMethod.DELETE)
    public void delete(@RequestBody String personJson) throws IOException {
        Person person = objectMapper.readValue(personJson, Person.class);
        personService.delete(person);
    }

    private Boolean validatate(){
        return true;
    }

}
