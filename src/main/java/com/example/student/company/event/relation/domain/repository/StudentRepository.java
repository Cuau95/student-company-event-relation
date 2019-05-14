package com.example.student.company.event.relation.domain.repository;

import com.example.student.company.event.relation.domain.model.Student;

public interface StudentRepository {
    
    public Student getStudentById(String id);
    
}
