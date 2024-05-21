package com.example.eserciziog2.controllers;

import com.example.eserciziog2.entities.BlogPost;
import com.example.eserciziog2.services.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/blogs")
public class BlogPostController {

    @Autowired
    BlogPostService blogPostService;

    @GetMapping("")
    public List<BlogPost> blogPostList(){
        return blogPostService.getAll();
    }

    @GetMapping("/{id}")
    public BlogPost blogPost(@PathVariable int id){
        return  blogPostService.findById(id);
    }


}
