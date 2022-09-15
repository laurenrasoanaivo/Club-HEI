package com.example.clubheidemo.repository;

import com.example.clubheidemo.model.Groups;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupsRepository extends JpaRepository<Groups, Long> {
    List<Groups> findAll();

    Optional<Groups> findById(Long id);

    Groups getByName(String name);

    Optional<Groups> findByName(String name);

}