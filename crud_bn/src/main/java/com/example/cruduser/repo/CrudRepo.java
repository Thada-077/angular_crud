package com.example.cruduser.repo;

import com.example.cruduser.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CrudRepo extends JpaRepository<User,Integer> {
}
