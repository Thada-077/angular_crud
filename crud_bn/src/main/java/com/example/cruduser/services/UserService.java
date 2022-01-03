package com.example.cruduser.services;

import com.example.cruduser.model.Login;
import com.example.cruduser.repo.LoginRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private LoginRepo repo;

    public List<Login> findAll(){
        return repo.findAll();
    }

    public Login saveUser(Login login) {
        return repo.save(login);
    }

    public Login fetchUserByEmailId(String email) {
        return repo.findByEmailId(email);
    }

    public Login fetchUserByEmailIdAndPassword(String email, String password) {
        return repo.findByEmailIdAndPassword(email,password);
    }
}
