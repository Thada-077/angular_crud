package com.example.cruduser.repo;

import com.example.cruduser.model.Login;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepo extends JpaRepository<Login, Integer> {
    public Login findByEmailId(String emailId);
    public Login findByEmailIdAndPassword(String emailId, String password);
}
