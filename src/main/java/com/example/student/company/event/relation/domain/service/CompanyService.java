package com.example.student.company.event.relation.domain.service;

import com.example.student.company.event.relation.domain.model.Company;
import com.example.student.company.event.relation.domain.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {
    
    private CompanyRepository companyRepository;

    @Autowired
    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }
    
    public Company getcompanyById(String id) {
        return companyRepository.getCompanyById(id);
    }
    
}
