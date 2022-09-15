package com.example.clubheidemo.controller;

import com.example.clubheidemo.model.Club;
import com.example.clubheidemo.repository.StudentRepository;
import com.example.clubheidemo.service.ClubService;
import com.example.clubheidemo.service.StudentService;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class ClubController {
    private final ClubService clubService;
    private final StudentRepository studentRepository;
    private final StudentService studentService;

    @GetMapping("/clubs")
    public List<Club> getAll(@RequestParam(value = "name", required = false) String name) {
        return clubService.getAll(name);
    }

    @GetMapping("/clubs/{id}")
    public Optional<Club> findById(@PathVariable(required = true) Long id) {
        return clubService.findById(id);
    }

    @PutMapping("/clubs")
    public Club saveClub(@Validated @RequestBody(required = true) Club club) {
        return clubService.saveClub(club);
    }

    @PatchMapping("/clubs/{id}")
    public Club updateClub(@PathVariable(required = true) Long id,
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "description", required = false) String description) {
        return clubService.updateClub(id, name, description, studentRepository, studentService);
    }

}
