package com.howtodoinjava.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.howtodoinjava.demo.model.ThDistrict;
import com.howtodoinjava.demo.model.ThProvince;
import com.howtodoinjava.demo.repository.DistrictRepository;
import com.howtodoinjava.demo.repository.ProvinceRepository;

@Service
public class AddressService {

	@Autowired
	private ProvinceRepository provinceRepository;
	@Autowired
	private DistrictRepository districtRepository;
	
	public List<ThProvince> getAllProvince(){
		return this.provinceRepository.findAll();
	}
	
	public List<ThDistrict> getDistrict( Short provinceId){
		return this.districtRepository.findByProvinceIdId(provinceId);
	}
	public ThDistrict getDistrictByName( String districtName){
		return this.districtRepository.findByNameTh(districtName);
	}
	public ThDistrict searchDistrictByName( String districtName){
		return this.districtRepository.searchNameTh(districtName);
	}
	
	
}
