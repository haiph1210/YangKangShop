package com.vti.service;

import com.vti.entity.Person;
import com.vti.repository.IPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PersonService implements IPersonService{
    @Autowired // auto new
    private IPersonRepository repository;
    @Override
    public List<Person> findAll() {
        return repository.findAll();
    }

    @Override
    public Person findByID(int id) {
        return repository.findByID(id);
    }

    @Override
    public Person findByEmail(String email) {
        return repository.findByEmail(email);
    }

    @Override
    public void create(Person person) {
        repository.create(person);
    }

    @Override
    public void update(Person person) {
        repository.update(person);
    }

    @Override
    public void deleteByID(int id) {
        repository.deleteByID(id);
    }
}
