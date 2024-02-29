package com.example.realestate.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.realestate.model.Post;
import com.example.realestate.repository.PostRepository;

@Service
public class PostService {
    public PostRepository postRepository;
    public PostService(PostRepository postRepository)
    {
        this.postRepository = postRepository;
    }
    public boolean savePost(Post post)
    {
        try
        {
            postRepository.save(post);
        }
        catch(Exception e)
        {
            return false;
        }
        return true;
    }
    public List<Post> getPost()
    {
        return postRepository.findAll();
    }
    public Post getPostById(int id)
    {
        return postRepository.findById(id).orElse(null);
    }
}

