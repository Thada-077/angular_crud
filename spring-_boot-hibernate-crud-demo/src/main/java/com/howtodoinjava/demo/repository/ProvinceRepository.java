package com.howtodoinjava.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.howtodoinjava.demo.model.ThProvince;

@Repository
public interface ProvinceRepository extends JpaRepository<ThProvince, Short> {
	
	
}
