package com.example.cruduser.repo;

import com.example.cruduser.model.AddressType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressTypeRepo extends JpaRepository <AddressType, Long>{
}
