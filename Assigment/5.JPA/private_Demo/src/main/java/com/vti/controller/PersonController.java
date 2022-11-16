package com.vti.controller;

import com.vti.entity.Person;
import com.vti.repository.IPersonRepository;
import com.vti.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/v1/persons")
public class PersonController {
    @Autowired // auto new
    private IPersonService service;

    @GetMapping
    public List<Person> findAll() {
        return service.findAll();
    }
    @GetMapping("/{id}")
    public Person findByID(@PathVariable int id) {
        return service.findByID(id);
    }

    @GetMapping("/email/{email}")
    public Person findByEmail(@PathVariable String email) {
        return service.findByEmail(email);
    }

    @PostMapping
    public void create(@RequestBody Person person) {
        service.create(person);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody Person person) {
        person.setId(id);
        service.update(person);
    }
    @DeleteMapping("/{id}")
    public void deleteByID(@PathVariable int id) {
        service.deleteByID(id);
    }
}
