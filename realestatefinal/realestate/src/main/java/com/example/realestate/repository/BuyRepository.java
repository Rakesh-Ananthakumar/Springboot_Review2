package com.example.realestate.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.realestate.model.Buy;

@Repository
public interface BuyRepository extends JpaRepository<Buy,Integer>{


    @Query("SELECT b FROM Buy b WHERE b.place=?1")
    List<Buy> findByPlace(String place);
    
    @Query("SELECT b FROM Buy b WHERE b.property=?1")
    List<Buy> findByProperty(String property);
}
