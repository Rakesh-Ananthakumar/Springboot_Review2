package com.example.realestate.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.realestate.model.Post;

public interface PostRepository extends JpaRepository<Post,Integer>{
    
}
