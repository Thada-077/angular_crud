package com.example.cruduser.controller;

import com.example.cruduser.exception.RecordNotFoundException;
import com.example.cruduser.model.ThDistrict;
import com.example.cruduser.model.ThProvince;
import com.example.cruduser.model.ThSubdistrict;
import com.example.cruduser.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {
    @Autowired
    AddressService addressService;

    @GetMapping("getProvince")
    public ResponseEntity<List<ThProvince>> getAllProvince(){
        List<ThProvince> list = addressService.getAllProvince();
        return ResponseEntity.ok(list);
    }

    @GetMapping("getDistrictAll")
    public ResponseEntity<List<ThDistrict>> getAllDistrict(){
        List<ThDistrict> list = addressService.getAllDistrict();
        return ResponseEntity.ok(list);
    }

    @GetMapping("getSubdistrictAll")
    public ResponseEntity<List<ThSubdistrict>> getAllSubdistrict(){
        List<ThSubdistrict> list = addressService.getAllSubDistrict();
        return ResponseEntity.ok(list);
    }

   //@GetMapping("getDistrict/{provinceId}")
   //public ResponseEntity<List<ThDistrict>> getDistrictById(@PathVariable("provinceId")Short provinceId) throws RecordNotFoundException {
       //List<ThDistrict> entity = addressService.getDistrict(provinceId);
       //return ResponseEntity.ok(entity);
    //}

//    @GetMapping("getSubdistrict/{districtId}")
//    public ResponseEntity<List<ThSubdistrict>> getSubdistrictById(@PathVariable("districtId")Short districtId) throws RecordNotFoundException {
//        List<ThSubdistrict> entity = addressService.getSubdistrict(districtId);
//        return ResponseEntity.ok(entity);
//    }
}
