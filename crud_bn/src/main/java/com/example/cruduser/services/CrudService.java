package com.example.cruduser.services;

import com.example.cruduser.model.User;
import com.example.cruduser.repo.CrudRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CrudService {
    @Autowired
    private CrudRepo repo;
    private User userToUpdate;
    public List<User> fetchUserList(){
        return repo.findAll();
    }

    public User saveUserToDB(User user){
        return repo.save(user);
    }

    public Optional<User> fetchUserById(int id){
        return repo.findById(id);
    }

    public String updateUserInRepository(User user) {
        try {
            userToUpdate = repo.getOne(user.getId());
            userToUpdate.setTitle(user.getTitle());
            userToUpdate.setFname(user.getFname());
            userToUpdate.setLname(user.getLname());
            userToUpdate.setAddress(user.getAddress());
            repo.save(userToUpdate);
            return "Product Updated";
        }catch (Exception e){
            return "There is no product registered under the ID: "+user.getId()+"\nMake sure you you send a valid product!";
        }
    }

    public String deleteUserById(int id){
        String result;
        try {
            repo.deleteById(id);
            result = "delete Successfully";
        } catch (Exception e){
            result = "delete fail";
        }
        return result;
    }
}
