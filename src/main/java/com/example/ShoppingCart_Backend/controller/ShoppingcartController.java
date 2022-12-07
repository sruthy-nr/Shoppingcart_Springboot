package com.example.ShoppingCart_Backend.controller;

import com.example.ShoppingCart_Backend.dao.ShoppingcartDao;
import com.example.ShoppingCart_Backend.model.Shoppingcart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ShoppingcartController {

    @Autowired
    private ShoppingcartDao dao;

    @CrossOrigin(origins = "*")
    @GetMapping("/")
    public String Homepage(){
        return "WELCOME TO MY WEBSITE";
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/addproduct", consumes = "application/json", produces = "application/json")
    public Map<String, String> AddProduct(@RequestBody Shoppingcart s){
        System.out.println(s.getName().toString());
        System.out.println(s.getImage().toString());
        System.out.println(s.getCategory().toString());
        System.out.println(s.getDescription().toString());
        System.out.println(s.getPrice());
        dao.save(s);
        HashMap<String, String> map=new HashMap<>();
        map.put("status","success");
        return map;
    }

    @GetMapping(path = "/viewproduct")
    public List<Shoppingcart> ViewProduct(){

        return (List<Shoppingcart>) dao.findAll();
    }
}
