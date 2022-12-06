package com.ecse437.FinalProject.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TextResponseController {

    @GetMapping("/helloworld")
    public String helloWorld()
    {
        return "Hello world";
    }

}
