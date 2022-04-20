package com.example.demo.web.mappers;

import com.example.demo.model.Person;
import com.example.demo.web.views.PersonView;
import org.springframework.stereotype.Component;

@Component
public class WebMapper {

    public PersonView personToView(Person person) {
        return PersonView.builder()
                .id(person.getId())
                .email(person.getEmail())
                .surname(person.getSurname())
                .name(person.getName())
                .lastName(person.getLastName())
                .phone(person.getPhone())
                .build();
    }
}
