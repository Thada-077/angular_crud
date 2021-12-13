package com.example.cruduser.controller;

import com.example.cruduser.model.ThDistrict;
import com.example.cruduser.services.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DistrictController {
    @Autowired
    private DistrictService service;
    @GetMapping("/getdistrict")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<ThDistrict> fetchDistrictList(){
        List<ThDistrict> thDistricts = new ArrayList<ThDistrict>();
        thDistricts = service.fetchDistrictList();
        return thDistricts;
    }
}
