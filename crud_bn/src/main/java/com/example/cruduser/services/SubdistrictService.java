package com.example.cruduser.services;

import com.example.cruduser.model.ThSubdistrict;
import com.example.cruduser.repo.SubdistrictRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubdistrictService {
    @Autowired
    private SubdistrictRepo repo;
    public List<ThSubdistrict> fetchSubdistrictList(){
        return repo.findAll();
    }
}
