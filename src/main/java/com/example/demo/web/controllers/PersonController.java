package com.example.demo.web.controllers;

import com.example.demo.model.Person;
import com.example.demo.services.PersonService;
import com.example.demo.web.mappers.WebMapper;
import com.example.demo.web.requests.PersonCreateRequest;
import com.example.demo.web.views.PersonView;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/person")
public class PersonController {

    @Autowired
    PersonService personService;

    @Autowired
    WebMapper mapper;

    @Operation(description = "create person")
    @PostMapping("/create")
    public ResponseEntity<PersonView> create (@RequestBody PersonCreateRequest request){
        var person = Person.builder()
                .email(request.getEmail())
                .lastName(request.getLastName())
                .name(request.getName())
                .surname(request.getSurname())
                .phone(request.getPhone())
                .build();

        return ResponseEntity.ok(mapper.personToView(personService.create(person)));
    }

    @Operation(description = "get person by id")
    @GetMapping("/{id}")
    public ResponseEntity<PersonView> get (@PathVariable Long id){
        return ResponseEntity.ok(mapper.personToView(personService.getById(id)));
    }

}
