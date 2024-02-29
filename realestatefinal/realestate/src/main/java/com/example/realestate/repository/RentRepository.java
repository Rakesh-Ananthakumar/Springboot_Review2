package com.example.realestate.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.realestate.model.Rent;

@Repository
public interface RentRepository extends JpaRepository<Rent,Integer> {
     @Query("SELECT r FROM Rent r WHERE r.place=?1")
     List<Rent> findByPlace(String place);

     @Query("SELECT r FROM Rent r WHERE r.property=?1")
     List<Rent> findByProperty(String property);
}