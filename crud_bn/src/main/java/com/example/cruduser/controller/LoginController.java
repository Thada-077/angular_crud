package com.example.cruduser.controller;

import com.example.cruduser.model.Login;
import com.example.cruduser.model.User;
import com.example.cruduser.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class LoginController {
    @Autowired
    private UserService service;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/getloginall")
    @CrossOrigin(origins = "https://localhost:4200")
    public List<Login> findAll(){
        List<Login> logins = new ArrayList<Login>();
        logins = service.findAll();
        return logins;
    }

    @PostMapping("/registeruser")
    public Login registerUser(@RequestBody Login user) throws Exception {
        String tempEmailId = user.getEmailId();
        if (tempEmailId != null && !"".equals(tempEmailId)) {
            Login loginobj = service.fetchUserByEmailId(tempEmailId);
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            if (loginobj != null) {
                throw new Exception("user with " + tempEmailId + " is already exist");
            }
        }
        Login loginObj = null;
        loginObj = service.saveUser(user);
        return loginObj;
    }

    @PostMapping("/login")
    public Login loginUser(@RequestBody Login login) throws Exception {
        String tempEmailId = login.getEmailId();
        String tempPass = login.getPassword();
        Login loginObj = null;
        if(tempEmailId != null && tempPass != null) {
            loginObj = service.fetchUserByEmailIdAndPassword(tempEmailId, tempPass);
        }
        if(loginObj == null) {
            throw new Exception("Bad credentials");
        }
        return loginObj;
    }
}
