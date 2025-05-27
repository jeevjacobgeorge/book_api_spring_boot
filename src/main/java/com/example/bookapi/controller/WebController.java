package com.example.bookapi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class WebController {

    @GetMapping("")
    public String home() {
        return "home"; // renders templates/home.html
    }
}

