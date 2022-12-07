package com.example.ShoppingCart_Backend.controller;

import com.example.ShoppingCart_Backend.dao.ShoppingcartDao;
import com.example.ShoppingCart_Backend.dao.UserregistrationDao;
import com.example.ShoppingCart_Backend.model.Shoppingcart;
import com.example.ShoppingCart_Backend.model.Userregistration;
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
        dao.save(s);
        HashMap<String, String> map=new HashMap<>();
        map.put("status","success");
        return map;
    }

    @CrossOrigin(origins = "*")
    @GetMapping(path = "/viewproduct")
    public List<Shoppingcart> ViewProduct(){

        return (List<Shoppingcart>) dao.findAll();
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/searchproduct", consumes = "application/json", produces = "application/json")
    public List<Shoppingcart> SearchProduct(@RequestBody Shoppingcart s){

        return (List<Shoppingcart>) dao.searchProduct(s.getName());
    }

    @Autowired
    private UserregistrationDao dao1;
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/userregistration", consumes = "application/json", produces = "application/json")
    public Map<String, String> UserRegistration(@RequestBody Userregistration u){
        System.out.println(u.getName().toString());
        System.out.println(u.getAddress().toString());
        System.out.println(u.getPhone().toString());
        System.out.println(u.getEmail().toString());
        dao1.save(u);
        HashMap<String, String> map=new HashMap<>();
        map.put("status","success");
        return map;
    }
}
