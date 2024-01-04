package com.cms.CMS.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cms.CMS.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
   
}