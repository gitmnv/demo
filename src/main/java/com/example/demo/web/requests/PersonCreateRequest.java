package com.example.demo.web.requests;

import lombok.Data;

@Data
public class PersonCreateRequest {

    private String email;

    private String surname;

    private String name;

    private String lastName;

    private String phone;
}
