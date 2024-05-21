package com.example.eserciziog2.services;

import com.example.eserciziog2.entities.BlogPost;


import java.util.ArrayList;
import java.util.List;

public class BlogPostService {

    private final List<BlogPost> blogs = new ArrayList<>();

    public BlogPost save(BlogPost blogPost){
        blogPost.setCover("https://picsum.photos/200/300");
        this.blogs.add(blogPost);
        return blogPost;
    }

    public List<BlogPost> getBlogs() {
        return this.blogs;
    }
}
