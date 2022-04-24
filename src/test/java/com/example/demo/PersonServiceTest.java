package com.example.demo;

import com.example.demo.model.Person;

import com.example.demo.services.PersonService;
import org.junit.runner.RunWith;
import org.junit.Test;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonServiceTest {

    private String email = "john.cena@gmail.com";
    private String surname = "Cena";
    private String name = "John";
    private String lastName = "Ivanovich";
    private String phone = "222-333";

    @Autowired
    private PersonService personService;

    @Test
    public void testPersonService() {

        Person person = Person.builder()
                .name(name)
                .surname(surname)
                .lastName(lastName)
                .email(email)
                .phone(phone)
                .build();
        var value = personService.create(person);

        assertThat(value).isNotNull();

        assertThat(value.getId()).isNotNull();
        assertThat(value.getName()).isEqualTo(name);
        assertThat(value.getSurname()).isEqualTo(surname);
        assertThat(value.getLastName()).isEqualTo(lastName);
        assertThat(value.getEmail()).isEqualTo(email);
        assertThat(value.getPhone()).isEqualTo(phone);

        var dbPerson = personService.getById(value.getId());

        assertThat(dbPerson).isNotNull();

        assertThat(dbPerson).isEqualTo(value);
    }

}
