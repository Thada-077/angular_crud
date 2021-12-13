package com.example.cruduser.controller;

import com.example.cruduser.model.ThSubdistrict;
import com.example.cruduser.services.SubdistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class SubdistrictController {
    @Autowired
    private SubdistrictService service;

    @GetMapping("/getsubdistrict")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<ThSubdistrict> fetchSubdistrictList(){
        List<ThSubdistrict> thSubdistricts = new ArrayList<ThSubdistrict>();
        thSubdistricts = service.fetchSubdistrictList();
        return thSubdistricts;
    }
}
