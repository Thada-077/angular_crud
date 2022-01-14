package com.example.cruduser.repo;


import com.example.cruduser.model.ThDistrict;
import com.example.cruduser.model.ThSubdistrict;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DistrictRepo extends JpaRepository<ThDistrict,Short> {
    //List<ThDistrict> findByProvinceIdId(Short provinceId);
}
