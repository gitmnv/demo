package com.example.demo.services.impl;

import com.example.demo.model.Person;
import com.example.demo.services.PersonService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Service
public class DefaultPersonService implements PersonService {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public Person create(Person person) {
        entityManager.persist(person);
        entityManager.flush();
        entityManager.refresh(person);
        return person;
    }

    @Override
    public Person getById(Long id) {
        return entityManager.createQuery("SELECT p from Person p where p.id = :personId", Person.class)
                .setParameter("personId", id).getSingleResult();
    }
}
