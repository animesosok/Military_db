package ru.nsu.db.militarys.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class MainController {
    @GetMapping("/")
    public String mainController(){
        return "index";
    }
}
