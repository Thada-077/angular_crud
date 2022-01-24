package com.example.cruduser.repo;


import com.example.cruduser.model.ThSubdistrict;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubdistrictRepo extends JpaRepository<ThSubdistrict,Long> {
    List<ThSubdistrict> findByDistrictId(Long districtId);

    public ThSubdistrict findById(long id);
}
