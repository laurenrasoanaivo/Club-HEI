package com.example.clubheidemo.repository;

import com.example.clubheidemo.model.Club;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClubRepository extends JpaRepository<Club, Long> {
    
    List<Club> findAll();

    Optional<Club> findById(Long id);

    Club getByName(String name);

    Optional<Club> findByName(String name);

    List<Club> findByNameContaining(String query);

}