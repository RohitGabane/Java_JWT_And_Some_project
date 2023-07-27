package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUsername(String username);
}

