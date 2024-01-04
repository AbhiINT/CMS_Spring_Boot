package com.cms.CMS.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cms.CMS.entity.Post;
import com.cms.CMS.entity.User;
import com.cms.CMS.repository.PostRepository;
@Service
public class PostService {
    @Autowired
    private  PostRepository postRepository;

     public Post savePost(Post post) {
        return postRepository.save(post);
    }

    public Post getPostById(Integer postId) {
        return postRepository.findById(postId).orElse(null);
    }

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public List<Post> getPostsByUser(User user) {
        return postRepository.findByUser(user);
    }

   
    
}
