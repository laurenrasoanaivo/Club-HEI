package com.example.clubheidemo.service;

import com.example.clubheidemo.model.Club;
import com.example.clubheidemo.model.Event;
import com.example.clubheidemo.repository.ClubRepository;
import com.example.clubheidemo.repository.EventRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;
    private ClubRepository clubRepository;
    private Event event;

    public Event saveEvent(Event event, Long clubId, ClubRepository clubRepository) {
        Optional<Club> club = clubRepository.findById(clubId);
        if (club.isPresent()) {
            event.setClub(club.get());
            eventRepository.save(event);
            return event;
        } else {
            throw new RuntimeException("Resource Not Found");
        }
    }

    public List<Event> findAll() {
        return eventRepository.findAll();
    }

    public Optional<Event> findById(Long id) {
        return eventRepository.findById(id);
    }

    public List<Event> getAll(String event_name, String club_name) {
        if (event_name == null && club_name == null) {
            return eventRepository.findAll();
        } else if (club_name != null) {
            return eventRepository.getByClubName(club_name);
        }
        return findWhereNameLike(event_name);
    }

    public Event getById(Long id) {
        Optional<Event> event = findById(id);
        if (event.isPresent()) {
            return event.get();
        } else {
            throw new RuntimeException("Resource Not Found");
        }
    }

    public Event getByName(String name) {
        Optional<Event> event = eventRepository.findByName(name);
        if (event.isPresent()) {
            return event.get();
        }
        throw new RuntimeException("Resource Not Found");
    }

    public List<Event> findWhereNameLike(String query) {
        return eventRepository.findByNameContaining(query);
    }

    public List<Event> getByClubName(String club_name) {
        Club club = clubRepository.getByName(club_name);
        List<Event> events = new ArrayList<>();
        if (event.getClub() == club) {
            events.add(event);
        }
        return events;
    }

    public Event updateEvent(Long id, LocalDateTime startEvent, LocalDateTime endEvent, Long clubId, ClubRepository clubRepository) {
        Optional<Event> event = findById(id);
        if(event.isPresent() && clubId!=null){
            Optional<Club> club = clubRepository.findById(id);
            if(startEvent!=null && endEvent!=null){
                event.get().setClub(club.get());
                event.get().setEndEvent(endEvent);
                event.get().setStartEvent(startEvent);
                return event.get();
            } else if(startEvent!=null && endEvent==null){
                event.get().setClub(club.get());
                event.get().setStartEvent(startEvent);
                return event.get();
            } else if(startEvent==null && endEvent!=null){
                event.get().setClub(club.get());
                event.get().setEndEvent(endEvent);
                return event.get();
            } else {
                event.get().setClub(club.get());
                return event.get();
            }
        } else if(event.isPresent() && clubId==null){
            if(startEvent!=null && endEvent==null){
                event.get().setStartEvent(startEvent);
                return event.get();
            } else {
                event.get().setEndEvent(endEvent);
                return event.get();
            } 
        } else {
            throw new RuntimeException("Resource Not Found");
        }
    }

}
