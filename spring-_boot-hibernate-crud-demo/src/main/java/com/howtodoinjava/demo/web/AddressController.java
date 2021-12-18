package com.howtodoinjava.demo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.howtodoinjava.demo.exception.RecordNotFoundException;
import com.howtodoinjava.demo.model.ThDistrict;
import com.howtodoinjava.demo.model.ThProvince;
import com.howtodoinjava.demo.service.AddressService;

@RestController
@RequestMapping("/address")
public class AddressController {
	@Autowired
	AddressService addressService;

	@GetMapping("getProvince")
	public ResponseEntity<List<ThProvince>> getAllEmployees() {
		List<ThProvince> list = addressService.getAllProvince();

		return ResponseEntity.ok(list);
	}

	@GetMapping("getDistrict/{provinceId}")
	public ResponseEntity<List<ThDistrict>> getEmployeeById(@PathVariable("provinceId") Short provinceId)
			throws RecordNotFoundException {
		List<ThDistrict> entity = addressService.getDistrict(provinceId);
		return ResponseEntity.ok(entity);
	}

	@GetMapping("getDistrictByName")
	public ResponseEntity<ThDistrict> getDistrictByName(@RequestParam("districtName") String districtName)
			throws RecordNotFoundException {
		ThDistrict entity = addressService.getDistrictByName(districtName);
		return ResponseEntity.ok(entity);
	}
	
	@GetMapping("searchDistrictByName")
	public ResponseEntity<ThDistrict> searchDistrictByName(@RequestParam("districtName") String districtName)
			throws RecordNotFoundException {
		ThDistrict entity = addressService.searchDistrictByName(districtName);
		return ResponseEntity.ok(entity);
	}
}