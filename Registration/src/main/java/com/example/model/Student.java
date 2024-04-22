package com.example.model;

import lombok.Data;

import java.util.Date;

@Data
public class Student {
    private String name;
    private String password;
    private String email;
    private Date birthdate;
}
