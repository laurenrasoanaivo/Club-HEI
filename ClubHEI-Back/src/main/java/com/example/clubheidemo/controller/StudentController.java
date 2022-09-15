package com.example.clubheidemo.controller;

import com.example.clubheidemo.model.Student;
import com.example.clubheidemo.repository.ClubRepository;
import com.example.clubheidemo.repository.GroupsRepository;
import com.example.clubheidemo.service.ClubService;
import com.example.clubheidemo.service.GroupsService;
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
public class StudentController {
    private final StudentService studentService;
    private final GroupsRepository groupsRepository;
    private final ClubRepository clubRepository;
    private final GroupsService groupsService;
    private final ClubService clubService;

    @GetMapping("/students")
    public List<Student> getAll(@RequestParam(value = "first_name", required = false) String first_name,
            @RequestParam(value = "groups_name", required = false) String groups_name) {
        return studentService.getAll(first_name, groups_name);
    }

    @GetMapping("/members")
    public List<Student> getMembers(@RequestParam(value = "club_name", required = false) String club_name) {
        return studentService.getMembers(club_name, clubRepository);
    }

    @GetMapping("/students/{id}")
    public Optional<Student> findById(@PathVariable(required = true) Long id) {
        return studentService.findById(id);
    }

    @PutMapping("/students")
    public Student saveStudent(@RequestParam(value = "groups_id", required = true) Long groupsId,
            @RequestParam(value = "club_id", required = false) Long clubId,
            @Validated @RequestBody(required = true) Student student) {
        return studentService.saveStudent(student, groupsId, clubId, clubRepository, groupsRepository, clubService, groupsService);
    }

    @PatchMapping("/students/{id}")
    public Student updateStudents(@PathVariable(required = true) Long id,
            @RequestParam(value = "groups_id", required = false) Long groupsId,
            @RequestParam(value = "club_id", required = false) Long clubId) {
        return studentService.updateStudent(id, groupsId, clubId, clubService, groupsService);
    }

}
