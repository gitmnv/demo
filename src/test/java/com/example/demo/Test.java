package com.example.demo;

import com.example.demo.model.Person;
import com.example.demo.web.mappers.WebMapper;
import com.example.demo.web.views.PersonView;
import org.junit.jupiter.api.DisplayName;

import static org.assertj.core.api.Assertions.assertThat;

public class Test {
    private final Long id = 1L;
    private final String email = "john.cena@gmail.com";
    private final String surname = "Cena";
    private final String name = "John";
    private final String lastName = "Ivanovich";
    private final String phone = "222-333";

    @org.junit.jupiter.api.Test
    @DisplayName("Mapper test")
    void mapperTest() {


        WebMapper mapper = new WebMapper();
        Person person = Person.builder()
                .id(id)
                .name(name)
                .surname(surname)
                .lastName(lastName)
                .email(email)
                .phone(phone)
                .build();

        var view = mapper.personToView(person);

        assertThat(person.getId()).isEqualTo(view.getId());
        assertThat(person.getName()).isEqualTo(view.getName());
        assertThat(person.getSurname()).isEqualTo(view.getSurname());
        assertThat(person.getLastName()).isEqualTo(view.getLastName());
        assertThat(person.getEmail()).isEqualTo(view.getEmail());
        assertThat(person.getPhone()).isEqualTo(view.getPhone());
    }

    @org.junit.jupiter.api.Test
    @DisplayName("View test")
    void viewTest(){
        PersonView view = PersonView.builder()
                .id(id)
                .name(name)
                .surname(surname)
                .lastName(lastName)
                .email(email)
                .phone(phone)
                .build();

        assertThat(id).isEqualTo(view.getId());
        assertThat(name).isEqualTo(view.getName());
        assertThat(surname).isEqualTo(view.getSurname());
        assertThat(lastName).isEqualTo(view.getLastName());
        assertThat(email).isEqualTo(view.getEmail());
        assertThat(phone).isEqualTo(view.getPhone());
    }
}
