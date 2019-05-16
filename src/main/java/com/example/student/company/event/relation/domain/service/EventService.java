package com.example.student.company.event.relation.domain.service;

import com.example.student.company.event.relation.domain.model.Event;
import com.example.student.company.event.relation.domain.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService {
    
    private EventRepository eventRepository;

    @Autowired
    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }
    
    public Event getEventById(String id) {
        return eventRepository.getEventById(id);
    }
    
}
