package com.example.cruduser.services;

import com.example.cruduser.model.ThProvince;
import com.example.cruduser.repo.ProvinceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvinceService {
    @Autowired
    private ProvinceRepo repo;

    public List<ThProvince> fetchProvinceList(){
        return repo.findAll();
    }
}
