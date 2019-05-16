package com.example.student.company.event.relation.infrastruture.repository;

import com.example.student.company.event.relation.domain.model.Event;
import com.example.student.company.event.relation.domain.repository.EventRepository;
import java.net.URI;
import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.http.HttpMethod.GET;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Repository
public class EventHttpClientRepository implements EventRepository{
    
    private RestTemplate restTemplate;

    @Autowired
    public EventHttpClientRepository(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Event getEventById(String id) {
        try {
            ResponseEntity<Event> res = restTemplate.exchange(buildStudentIsRequest(id), Event.class);
            return res.getBody();
        } catch (RestClientException ex) {
            return null;
        }
    }

    private RequestEntity<String> buildStudentIsRequest(String id) {
        return new RequestEntity<>(GET, buildURI(id));
    }

    private URI buildURI(String id) {
        String uri = new StringBuilder().append("http://localhost:8081/")
                .append("employment_fair/id/")
                .append(id)
                .toString();
        return URI.create(uri);
    }
    
}
