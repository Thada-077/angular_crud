package com.example.cruduser.controller;

import com.example.cruduser.model.User;
import com.example.cruduser.services.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CrudRestController {
    @Autowired
    private CrudService service;

    @GetMapping("/getuserlist")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<User> fetchUserList(){
        List<User> users = new ArrayList<User>();
        users = service.fetchUserList();
        return users;
    }

    @PostMapping("/adduser")
    @CrossOrigin(origins = "http://localhost:4200")
    public User saveUser(@RequestBody User user){
        return service.saveUserToDB(user);
    }

    @GetMapping("/getuserbyid/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public User fetchUserbyId(@PathVariable int id){
        return service.fetchUserById(id).get();
    }

    @PostMapping("/edituser")
    @CrossOrigin(origins = "http://localhost:4200")
    public String updateUser(@RequestBody User user){
        return service.updateUserInRepository(user);
    }

    @DeleteMapping("/deleteuserbyid/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public String DeleteUserbyId(@PathVariable int id){
        return service.deleteUserById(id);
    }
}
