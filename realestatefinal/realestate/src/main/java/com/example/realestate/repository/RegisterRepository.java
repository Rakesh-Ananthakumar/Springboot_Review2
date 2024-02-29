package com.example.realestate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.realestate.model.Register;

@Repository
public interface RegisterRepository extends JpaRepository<Register,String>{
    
}
