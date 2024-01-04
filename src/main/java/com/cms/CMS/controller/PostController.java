package com.cms.CMS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cms.CMS.entity.Post;
import com.cms.CMS.entity.User;
import com.cms.CMS.service.PostService;
import com.cms.CMS.service.UserService;

@RestController
@RequestMapping("/posts")
public class PostController {
    @Autowired
    private  PostService postService;
    @Autowired
    private UserService userService;

   
    

    @PostMapping("/{i}")
    public ResponseEntity<Post> createPost(@RequestBody Post post,@PathVariable Integer i) {
        post.setUser(userService.getUserById(i));
        Post savedPost = postService.savePost(post);
        return ResponseEntity.ok(savedPost);
    }

    @GetMapping("/{postId}")
    public ResponseEntity<Post> getPostById(@PathVariable Integer postId) {
        Post post = postService.getPostById(postId);
        if (post != null) {
            return ResponseEntity.ok(post);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Post>> getAllPosts() {
        List<Post> posts = postService.getAllPosts();
        return ResponseEntity.ok(posts);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Post>> getPostsByUser(@PathVariable Integer userId) {
        User user = userService.getUserById(userId);
        if (user != null) {
            List<Post> posts = postService.getPostsByUser(user);
            return ResponseEntity.ok(posts);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Add more endpoints as needed

}