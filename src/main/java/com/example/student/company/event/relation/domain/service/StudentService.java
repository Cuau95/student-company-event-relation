package com.example.student.company.event.relation.domain.service;

import com.example.student.company.event.relation.domain.model.Student;
import com.example.student.company.event.relation.domain.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    
    private StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    
    public Student getStudentById(String id) {
        return studentRepository.getStudentById(id);
    }
    
}
