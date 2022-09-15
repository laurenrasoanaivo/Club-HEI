package com.example.clubheidemo.repository;

import com.example.clubheidemo.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}