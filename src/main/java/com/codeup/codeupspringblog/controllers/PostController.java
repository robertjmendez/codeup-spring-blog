package com.codeup.codeupspringblog.controllers;

import com.codeup.codeupspringblog.model.Post;
import com.codeup.codeupspringblog.model.User;
import com.codeup.codeupspringblog.repositories.PostRepository;
import com.codeup.codeupspringblog.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PostController {

    private final PostRepository postDao;

    private final UserRepository userDao;


    public PostController(PostRepository postDao, UserRepository userDao) {
        this.postDao = postDao;
        this.userDao = userDao;
    }

    @GetMapping("/posts")
    public String allPosts(Model model) {
        model.addAttribute("posts", postDao.findAll());
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String individualPost(@PathVariable long id, Model model) {
        Post post = postDao.findPostById(id);
        if (post != null) {
            model.addAttribute("post", post);
            return "posts/show";
        } else {
            return "redirect:/posts";
        }
    }

    @GetMapping("/posts/create")
    public String viewCreateForm(Model model) {
        model.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String createPost(@ModelAttribute Post post) {
        User user = userDao.findById(1L).get();
        post.setUser(user);
        postDao.save(post);
        return "redirect:/posts";
    }

    @GetMapping("/posts/{id}/edit")
    public String editPostForm(@PathVariable long id, Model model) {
        Post post = postDao.findPostById(id);
        if (post != null) {
            model.addAttribute("post", post);
            return "posts/edit";
        } else {
            return "redirect:/posts";
        }
    }

    @PostMapping("/posts/update")
    public String updatePost(@ModelAttribute Post post) {
        User user = userDao.findById(1L).get();
        post.setUser(user);
        postDao.save(post);
        return "redirect:/posts";
    }

}
