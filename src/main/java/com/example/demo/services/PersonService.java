package com.example.demo.services;

import com.example.demo.model.Person;

public interface PersonService {

    Person create(Person person);

    Person getById(Long id);
}
