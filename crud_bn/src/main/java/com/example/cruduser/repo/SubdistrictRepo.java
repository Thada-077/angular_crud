package com.example.cruduser.repo;


import com.example.cruduser.model.ThSubdistrict;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubdistrictRepo extends JpaRepository<ThSubdistrict,Short> {
        //List<ThSubdistrict> findByDistrictIdId(Short districtId);
}
