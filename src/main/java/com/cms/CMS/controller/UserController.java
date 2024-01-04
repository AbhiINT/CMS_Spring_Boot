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
import com.cms.CMS.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private  UserService userService;

   
   

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User savedUser = userService.saveUser(user);
        return ResponseEntity.ok(savedUser);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable Integer userId) {
        User user = userService.getUserById(userId);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }
    @GetMapping("/getAllPostByUserId/{id}")
    public ResponseEntity<List<Post>> getAllPostByUserId(@PathVariable Integer id)
    {
        List<Post> lst=userService.getUserById(id).getPosts();
        return ResponseEntity.ok(lst);
    }

    // Add more endpoints as needed

}
