package com.vti.service;

import com.vti.entity.Person;

import java.util.List;

public interface IPersonService {

    List<Person> findAll();

    Person findByID(int id);

    Person findByEmail(String email);

    void create(Person person);

    void update(Person person);

    void deleteByID(int id);
}
