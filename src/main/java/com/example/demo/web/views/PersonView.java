package com.example.demo.web.views;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PersonView {

    private Long id;

    private String email;

    private String surname;

    private String name;

    private String lastName;

    private String phone;
}
