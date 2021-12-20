package com.example.cruduser.repo;

import com.example.cruduser.model.ThProvince;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProvinceRepo extends JpaRepository<ThProvince,Short> {

}
