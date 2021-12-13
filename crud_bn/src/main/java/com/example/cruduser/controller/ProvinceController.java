package com.example.cruduser.controller;


import com.example.cruduser.model.ThProvince;
import com.example.cruduser.services.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProvinceController {
    @Autowired
    private ProvinceService service;

    @GetMapping("/getprovince")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<ThProvince> fetchProvinceList(){
        List<ThProvince> thProvinces = new ArrayList<ThProvince>();
        thProvinces = service.fetchProvinceList();
        return thProvinces;
    }
}
