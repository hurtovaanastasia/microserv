package com.example.microserv.person.controller;

import com.example.microserv.person.model.Person;
import com.example.microserv.person.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonRepository personRep;

    @GetMapping
    public Iterable<Person> findAll() {
        return personRep.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Person> findById(@PathVariable int id) {
        return personRep.findById(id);
    }

    @PostMapping
    public ResponseEntity<Person> save(@RequestBody Person person) {
        return personRep.findById(person.getId()).isPresent()
                ? new ResponseEntity(personRep.findById(person.getId()), HttpStatus.BAD_REQUEST)
                : new ResponseEntity(personRep.save(person), HttpStatus.CREATED);
    }
}