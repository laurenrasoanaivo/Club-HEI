package com.example.clubheidemo.controller;

import com.example.clubheidemo.model.Event;
import com.example.clubheidemo.repository.ClubRepository;
import com.example.clubheidemo.service.EventService;

import lombok.AllArgsConstructor;

import java.time.LocalDateTime;
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
public class EventController {
    private final EventService eventService;
    private final ClubRepository clubRepository;

    @GetMapping("/events")
    public List<Event> getAll(@RequestParam(value = "event_name", required = false) String event_name,
            @RequestParam(value = "club_name", required = false) String club_name) {
        return eventService.getAll(event_name, club_name);
    }

    @GetMapping("/events/{id}")
    public Optional<Event> findById(@PathVariable(required = true) Long id) {
        return eventService.findById(id);
    }

    @PutMapping("/events")
    public Event saveEvents(@RequestParam(value = "club_id", required = true) Long clubId, 
            @Validated @RequestBody Event event) {
        return eventService.saveEvent(event, clubId, clubRepository);
    }

    @PatchMapping("/events/{id}")
    public Event updateGroups(@PathVariable(required = true) Long id,
            @RequestParam(value = "start_event", required = false) LocalDateTime startEvent,
            @RequestParam(value = "end_event", required = false) LocalDateTime endEvent,
            @RequestParam(value = "club_id", required = false) Long clubId) {
        return eventService.updateEvent(id, startEvent, endEvent, clubId, clubRepository);
    }

}
