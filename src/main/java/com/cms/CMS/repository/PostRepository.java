package com.cms.CMS.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cms.CMS.entity.Post;
import com.cms.CMS.entity.User;

public interface PostRepository extends JpaRepository<Post, Integer> {
    List<Post> findByUser(User user);
}
