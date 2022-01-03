package com.example.cruduser.services;

import com.example.cruduser.model.ThDistrict;
import com.example.cruduser.model.ThProvince;
import com.example.cruduser.model.ThSubdistrict;
import com.example.cruduser.repo.DistrictRepo;
import com.example.cruduser.repo.ProvinceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {
    @Autowired
    private DistrictRepo districtRepo;
    @Autowired
    private ProvinceRepo provinceRepo;

    public List<ThProvince> getAllProvince(){return this.provinceRepo.findAll();}

    public List<ThDistrict> getDistrict(Short provinceId){
        return this.districtRepo.findByProvinceIdId(provinceId);
   }
    //public List<ThSubdistrict> getSubdistrict(Short districtId){return this.districtRepo.findByDistrictIdId(districtId);}
}
