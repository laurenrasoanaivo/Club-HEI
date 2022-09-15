package com.example.clubheidemo.repository;

import com.example.clubheidemo.model.Club;
import com.example.clubheidemo.model.Groups;
import com.example.clubheidemo.model.Student;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findAll();

    Optional<Student> findById(Long id);

    Student getByRef(String ref);

    Optional<Student> findByRef(String ref);

    List<Student> getByClubName(String club_name);

    List<Student> findByClub(Club club);

    Optional<Student> findByFirstName(String firstName);

    List<Student> findByGroups(Groups groups);

    List<Student> getByGroupsName(String groups_name);

    List<Student> findByFirstNameContaining(String query);

}