package com.vti.repository;

import com.vti.entity.Person;

import java.util.List;

public interface IPersonRepository {
    List<Person> findAll();

    Person findByID(int id);

    Person findByEmail(String email);

    void create(Person person);

    void update(Person person);

    void deleteByID(int id);
}
