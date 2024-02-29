package com.example.realestate.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.example.realestate.model.Post;
import com.example.realestate.service.PostService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
public class PostController {
    public PostService postService;
    public PostController(PostService postService)
    {
        this.postService = postService;
    }
    @PostMapping("/post")
    public ResponseEntity<Post> postMethodName(@RequestBody Post post) {
        if(postService.savePost(post))
        {
            return new ResponseEntity<>(post,HttpStatus.CREATED);
        }
        return new ResponseEntity<>(post,HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @GetMapping("/getposts")
    public ResponseEntity<List<Post>> getMethod()
    {
        List<Post> list = postService.getPost();
        if(list.size()==0)
        {
            return new ResponseEntity<>(list,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(list,HttpStatus.OK);
    }
    @GetMapping("/getpost/{id}")
    public ResponseEntity<Post> getMethodName(@PathVariable("id") int id)
    {
        Post post = postService.getPostById(id);
        if(post==null)
        {
            return new ResponseEntity<>(post,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(post,HttpStatus.OK);
    }
    
}
