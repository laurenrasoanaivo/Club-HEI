package com.example.clubheidemo.service;

import com.example.clubheidemo.model.Club;
import com.example.clubheidemo.repository.ClubRepository;
import com.example.clubheidemo.repository.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ClubService {

    @Autowired
    private ClubRepository clubRepository;

    public List<Club> findAll() {
        return clubRepository.findAll();
    }

    public Optional<Club> findById(Long id) {
        return clubRepository.findById(id);
    }

    public Club getById(Long id) {
        Optional<Club> club = findById(id);
        if (club.isPresent()) {
            return club.get();
        } else {
            throw new RuntimeException("Resource Not Found");
        }
    }

    public List<Club> getAll(String name) {
        if (name != null) {
            return clubRepository.findByNameContaining(name);
        }
        return clubRepository.findAll();
    }

    public Club getByName(String name) {
        Optional<Club> club = clubRepository.findByName(name);
        if (club.isPresent()) {
            return club.get();
        }
        throw new RuntimeException("Resource Not Found");
    }

    public List<Club> findWhereNameLike(String query) {
        return clubRepository.findByNameContaining(query);
    }

    public Club saveClub(Club club) {
        if(club.getCreationDate()==null){
            club.setCreationDate(LocalDate.now());
        }
        clubRepository.save(club);
        return club;
    }

    public Club updateClub(Long id, String name, String description, StudentRepository studentRepository,
            StudentService studentService) {
        Optional<Club> club = clubRepository.findById(id);
        if (club.isPresent()) {
            if (name != null && description != null) {
                club.get().setName(name);
                club.get().setDescription(description);
                return club.get();
            } else if (name != null && description == null) {
                club.get().setName(name);
                return club.get();
            } else {
                club.get().setDescription(description);
                return club.get();
            }
        } else {
            throw new RuntimeException("Resource Not Found");
        }
    }

}
