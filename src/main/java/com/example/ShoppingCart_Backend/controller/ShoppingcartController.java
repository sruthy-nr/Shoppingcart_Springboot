package com.example.ShoppingCart_Backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShoppingcartController {

    @GetMapping("/")
    public String Homepage(){
        return "WELCOME TO MY WEBSITE";
    }
}
