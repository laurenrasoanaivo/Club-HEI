package com.example.clubheidemo.controller;

import com.example.clubheidemo.model.Groups;
import com.example.clubheidemo.repository.GroupsRepository;
import com.example.clubheidemo.service.GroupsService;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class GroupsController {
    private final GroupsService groupsService;
    private final GroupsRepository groupsRepository;

    @GetMapping("/groups")
    public List<Groups> getAll() {
        return groupsService.findAll();
    }

    @GetMapping("/groups/{id}")
    public Optional<Groups> findById(@PathVariable(required = true) Long id) {
        return groupsService.findById(id);
    }

    @PutMapping("/groups")
    public Groups saveGroups(@RequestBody Groups groups) {
        return groupsService.save(groups);
    }

    @PatchMapping("/groups/{id}")
    public Groups updateGroups(@PathVariable(required = true) Long id,
            @RequestParam(value = "name", required = false) String name) {
        return groupsService.updateGroups(id, name, groupsRepository);
    }

}
