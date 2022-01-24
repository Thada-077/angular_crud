package com.example.cruduser.repo;


import com.example.cruduser.model.ThDistrict;
import com.example.cruduser.model.ThSubdistrict;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DistrictRepo extends JpaRepository<ThDistrict,Long> {
    List<ThDistrict> findByProvinceId(Long provinceId);

    ThDistrict findByNameTh(String nameTh);

    @Query("select d from ThDistrict d where d.nameTh = :nameTh")

    ThDistrict searchNameTh(@Param("nameTh") String nameTh);

    public ThDistrict findById(long id);
}
