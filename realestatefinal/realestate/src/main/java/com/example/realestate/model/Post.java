package com.example.realestate.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int propertyId;
    private String propertyType;

    @JsonManagedReference
    @OneToMany(mappedBy = "buypost", cascade = CascadeType.ALL)
    private List<Buy> buy;

    @JsonManagedReference
    @OneToMany(mappedBy = "rentpost", cascade = CascadeType.ALL)
    private List<Rent> rent;
}





