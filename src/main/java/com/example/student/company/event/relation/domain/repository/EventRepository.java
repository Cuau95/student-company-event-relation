package com.example.student.company.event.relation.domain.repository;

import com.example.student.company.event.relation.domain.model.Event;

public interface EventRepository {
    
    public Event getEventById(String id);
    
}
