package com.example.clubheidemo.service;

import com.example.clubheidemo.model.Groups;
import com.example.clubheidemo.repository.GroupsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GroupsService {

    @Autowired
    private GroupsRepository GroupsRepository;

    public List<Groups> findAll() {
        return GroupsRepository.findAll();
    }

    public Groups save(Groups groups) {
        return GroupsRepository.save(groups);
    }

    public Optional<Groups> findById(Long id) {
        return GroupsRepository.findById(id);
    }

    public Groups getById(Long id) {
        Optional<Groups> Groups = findById(id);
        if (Groups.isPresent()) {
            return Groups.get();
        } else {
            throw new RuntimeException("Resource Not Found");
        }
    }

    public Groups getByName(String name) {
        Optional<Groups> Groups = GroupsRepository.findByName(name);
        if (Groups.isPresent()) {
            return Groups.get();
        }
        throw new RuntimeException("Resource Not Found");
    }

    public Groups updateGroups(Long id, String name, GroupsRepository groupsRepository) {
        Optional<Groups> groups = groupsRepository.findById(id);
        if (groups.isPresent() && name != null) {
            groups.get().setName(name);
            return groups.get();
        } else {
            throw new RuntimeException("Resource Not Found");
        }
    }
}
