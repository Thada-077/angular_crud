package com.howtodoinjava.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.howtodoinjava.demo.model.ThDistrict;

@Repository
public interface DistrictRepository extends JpaRepository<ThDistrict, Short> {
	
	List<ThDistrict> findByProvinceIdId( Short provinceId);
	ThDistrict findByNameTh( String nameTh);

	@Query("select d from ThDistrict d where d.nameTh = :nameTh")
	ThDistrict searchNameTh(@Param("nameTh") String nameTh);
	
}
