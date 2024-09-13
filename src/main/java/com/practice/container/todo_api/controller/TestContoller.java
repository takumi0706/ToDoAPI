package com.practice.container.todo_api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestContoller {

    @GetMapping
    public String test() {
        return "Test!";
    }

    @RequestMapping("/hello")
    public String hello() {
        return "Hello World!";
    }

    @RequestMapping("/bye")
    public String bye() {
        return "Goodbye!";
    }

}
