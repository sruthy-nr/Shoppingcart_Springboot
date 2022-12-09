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
        dao1.save(u);
        HashMap<String, String> map=new HashMap<>();
        map.put("status","success");
        return map;
    }
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/userlogin", consumes = "application/json", produces = "application/json")
    public HashMap<String, String> UserLogin(@RequestBody Userregistration u){

        String username=String.valueOf(u.getEmail());
        String password=String.valueOf(u.getPassword());
//        return (List<Userregistration>) dao1.userLogin(u.getEmail(),u.getPassword());
        List<Userregistration> result=(List<Userregistration>) dao1.userLogin(username, password);
        HashMap<String,String> st=new HashMap<>();
        if (result.size()==0)
        {
            st.put("status","failed");
        }
        else
        {
            int id=result.get(0).getId();
            st.put("userid",String.valueOf(id));
            st.put("status","success");
        }
        return st;
    }
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/profileview",consumes = "application/json",produces = "application/json")
    public List<Userregistration> ProfileView(@RequestBody Userregistration u)
    {
        return (List<Userregistration>) dao1.profileView(u.getId());

    }
}
