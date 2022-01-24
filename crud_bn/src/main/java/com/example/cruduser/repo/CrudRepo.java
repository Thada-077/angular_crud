package com.example.cruduser.repo;

import com.example.cruduser.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CrudRepo extends JpaRepository<User,Long> {
    public List<User> findAll();
    public List<User> findById(int id);
}
