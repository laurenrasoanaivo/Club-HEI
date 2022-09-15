package com.example.clubheidemo.repository;

import com.example.clubheidemo.model.Club;
import com.example.clubheidemo.model.Event;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

    List<Event> findAll();

    Optional<Event> findById(Long id);

    Optional<Event> findByName(String name);

    List<Event> getByClubName(String club_name);

    List<Event> findByClub(Club club);

    List<Event> findByNameContaining(String query);

}