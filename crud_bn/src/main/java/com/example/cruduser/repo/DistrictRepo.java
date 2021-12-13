package com.example.cruduser.repo;


import com.example.cruduser.model.ThDistrict;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DistrictRepo extends JpaRepository<ThDistrict,Short> {
}
