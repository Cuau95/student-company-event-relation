package com.example.student.company.event.relation.domain.repository;

import com.example.student.company.event.relation.domain.model.Company;

public interface CompanyRepository {
    
    public Company getCompanyById(String id);
    
}
