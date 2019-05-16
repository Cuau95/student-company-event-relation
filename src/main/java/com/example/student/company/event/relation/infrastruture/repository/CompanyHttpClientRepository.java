package com.example.student.company.event.relation.infrastruture.repository;

import com.example.student.company.event.relation.domain.model.Company;
import com.example.student.company.event.relation.domain.repository.CompanyRepository;
import java.net.URI;
import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.http.HttpMethod.GET;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Repository
public class CompanyHttpClientRepository implements CompanyRepository{
    
    private RestTemplate restTemplate;

    @Autowired
    public CompanyHttpClientRepository(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Company getCompanyById(String id) {
        try {
            ResponseEntity<Company> res = restTemplate.exchange(buildCompanyRequest(id), Company.class);
            return res.getBody();
        } catch (RestClientException ex) {
            return null;
        }
    }

    private RequestEntity<String> buildCompanyRequest(String id) {
        return new RequestEntity<>(GET, buildURI(id));
    }

    private URI buildURI(String id) {
        String uri = new StringBuilder().append("http://localhost:8082/")
                .append("/company/id/")
                .append(id)
                .toString();
        return URI.create(uri);
    }
    
}
