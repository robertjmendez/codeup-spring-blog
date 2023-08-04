package com.codeup.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostController {
    @ResponseBody
    @GetMapping("/posts")
    public String index() {
        return "posts index page";
    }

    @ResponseBody
    @GetMapping("/posts/{id}")
    public String viewPost(@PathVariable String id) {
        return "view an individual post with id: " + id;
    }

    @ResponseBody
    @GetMapping("/posts/create")
    public String viewCreateForm() {
        return "view the form for creating a post";
    }

    @ResponseBody
    @PostMapping("/posts/create")
    public String createPost() {
        return "create a new post";
    }
}
