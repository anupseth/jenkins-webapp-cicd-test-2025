package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/hello2")
public class HelloController2 {

    @GetMapping
    public String hello() {
        return "hello Jenkins CI CD 2";
    }


}
