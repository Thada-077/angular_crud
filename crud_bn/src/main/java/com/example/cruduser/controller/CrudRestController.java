package com.example.cruduser.controller;

import com.example.cruduser.model.User;
import com.example.cruduser.model.UserModel;
import com.example.cruduser.services.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CrudRestController {
    @Autowired
    private CrudService crudService;

    @RequestMapping("/findUserAll")
    public List<User> findUserAll() {
        return crudService.fetchUserList();
    }

    @GetMapping("/getUserAll")
    public @ResponseBody List<UserModel> getUserAll() {

        List<UserModel> result = crudService.findUserModelAll();
        return result;
    }

    @GetMapping("/getuserbyid/{id}")
    public @ResponseBody UserModel getUserById(@PathVariable int id) {

        UserModel result = crudService.findUserModelById(id);
        return result;
    }

    @PostMapping("/addUser")
    public @ResponseBody Boolean addUser(@RequestBody UserModel User) {
        return crudService.AddUser(User);
    }

    @PutMapping("/updateUser")
    public @ResponseBody Boolean updateUser(@RequestBody UserModel User) {
        return crudService.UpdateUser(User);
    }

    @RequestMapping(value = "/deleteUser/{id}", method = RequestMethod.DELETE)
    public @ResponseBody String deleteUser(@PathVariable long id) {
        return crudService.deleteUserById(id);
    }

}
