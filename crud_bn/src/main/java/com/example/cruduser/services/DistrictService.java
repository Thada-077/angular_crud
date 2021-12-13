package com.example.cruduser.services;

import com.example.cruduser.model.ThDistrict;
import com.example.cruduser.repo.DistrictRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistrictService {
    @Autowired
    private DistrictRepo repo;
    public List<ThDistrict> fetchDistrictList(){
        return repo.findAll();
    }
}
