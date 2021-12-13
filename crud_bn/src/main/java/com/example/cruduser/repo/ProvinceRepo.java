package com.example.cruduser.repo;

import com.example.cruduser.model.ThProvince;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProvinceRepo extends JpaRepository<ThProvince,Short> {
}
