package com.example.cruduser.controller;

import com.example.cruduser.model.Login;
import com.example.cruduser.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Autowired
    private UserService service;

    @PostMapping("/registeruser")
    public Login registerUser(@RequestBody Login user) throws Exception {
        String tempEmailId = user.getEmailId();
        if (tempEmailId != null && !"".equals(tempEmailId)) {
            Login loginobj = service.fetchUserByEmailId(tempEmailId);
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
