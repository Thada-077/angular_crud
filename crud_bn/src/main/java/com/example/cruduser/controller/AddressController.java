package com.example.cruduser.controller;

import com.example.cruduser.exception.RecordNotFoundException;
import com.example.cruduser.model.*;
import com.example.cruduser.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("getDistrict")
    public ResponseEntity<List<ThDistrict>> getAllDistrict(){
        List<ThDistrict> list = addressService.getAllDistrict();
        return ResponseEntity.ok(list);
    }

    @GetMapping("getSubdistrict")
    public ResponseEntity<List<ThSubdistrict>> getAllSubdistrict(){
        List<ThSubdistrict> list = addressService.getAllSubDistrict();
        return ResponseEntity.ok(list);
    }
    @GetMapping("getProvinceById/{provinceId}")
    public ResponseEntity<ThProvince> getProvinceById(
            @PathVariable("provinceId") Long provinceId) {
        ThProvince entity = addressService.getProvinceById(provinceId);
        return ResponseEntity.ok(entity);
    }

    @GetMapping("getDistrictById/{districtId}")
    public ResponseEntity<ThDistrict> getDistrictById(
            @PathVariable("districtId") Long districtId) {
        ThDistrict entity = addressService.getDistrictById(districtId);
        return ResponseEntity.ok(entity);
    }

    @GetMapping("getSubdistrictById/{subdistrictId}")
    public ResponseEntity<ThSubdistrict> getSubdistrictById(
            @PathVariable("subdistrictId") Long subdistrictId) {
        ThSubdistrict entity = addressService.getSubdistrctById(subdistrictId);
        return ResponseEntity.ok(entity);
    }

    @GetMapping("getDistrict/{provinceId}")
    public ResponseEntity<List<ThDistrict>> getDistrictByProvinceId(@PathVariable("provinceId") Long provinceId) {
        List<ThDistrict> entity = addressService.getDistrict(provinceId);
        return ResponseEntity.ok(entity);
    }

    @GetMapping("getSubdistrict/{districtId}")
    public ResponseEntity<List<ThSubdistrict>> getSubdistrictByDistrictId(
            @PathVariable("districtId") Long districtId) {
        List<ThSubdistrict> entity = addressService.getSubDistrict(districtId);
        return ResponseEntity.ok(entity);
    }

    @RequestMapping("/findAddressAll")
    public List<Address> findAddressAll() {
        return addressService.findAddressAll();
    }

    @RequestMapping(value = "/getAddressAll", method = RequestMethod.POST)
    public @ResponseBody List<AddressModel> getAddressAll() {

        List<AddressModel> result = addressService.findAddressModelAll();
        return result;
    }

    @RequestMapping(value = "/getAddressById/{id}", method = RequestMethod.POST)
    public @ResponseBody AddressModel getAddressById(@PathVariable int id) {

        AddressModel result = addressService.findAddressModelById(id);
        return result;
    }
}
