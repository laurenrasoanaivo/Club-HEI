package com.example.clubheidemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.clubheidemo.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
