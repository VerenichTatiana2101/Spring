package com.example.controller.rest;

import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @GetMapping("/hello")
    public String hello()
    {
        return "hello user";
    }

    @GetMapping("/ciao")
    public String ciao()
    {
        return "ciao user";
    }
}
