package com.example.cruduser.repo;

import com.example.cruduser.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepo extends JpaRepository<Address, Long> {

    public List<Address> findAll();

    public Address findById(long id);
}
