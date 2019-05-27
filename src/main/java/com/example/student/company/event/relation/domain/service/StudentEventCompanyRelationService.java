package com.example.student.company.event.relation.domain.service;

import com.example.student.company.event.relation.domain.helper.StudentEventCompanyRelationServiceHelper;
import com.example.student.company.event.relation.domain.model.Company;
import com.example.student.company.event.relation.domain.model.Event;
import com.example.student.company.event.relation.domain.model.Student;
import com.example.student.company.event.relation.domain.model.StudentEventCompanyRelation;
import com.example.student.company.event.relation.domain.model.StudentEventCompanyRelationEntity;
import com.example.student.company.event.relation.domain.repository.StudentEventCompanyRelationRepository;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentEventCompanyRelationService {

    private CompanyService companyService;
    private EventService eventService;
    private StudentService studentService;
    private StudentEventCompanyRelationRepository repository;
    private StudentEventCompanyRelationServiceHelper relationHelper;

    @Autowired
    public StudentEventCompanyRelationService(CompanyService companyService, EventService eventService, StudentService studentService, StudentEventCompanyRelationRepository repository, StudentEventCompanyRelationServiceHelper relationHelper) {
        this.companyService = companyService;
        this.eventService = eventService;
        this.studentService = studentService;
        this.repository = repository;
        this.relationHelper = relationHelper;
    }
    
    public StudentEventCompanyRelation saveStudentEventCompanyRelation(
            String idStudent, String idCompany, String idEvent
    ) {
        Company company = getCompanyById(idCompany);
        Event event = getEventById(idEvent);
        Student student = getStudentById(idStudent);
        StudentEventCompanyRelation relation = buildStudentEventCompanyRelation(company, student, event);
        if(company != null && event != null && student != null){
            StudentEventCompanyRelationEntity relationSaved = saveRelation(company, student, event);
            relation.setFecha(relationSaved.getFechaRelacion());
            relation.setIdRelacion(relationSaved.getIdRelacion());
        }
        return relation;
    }
    
    public List<StudentEventCompanyRelation> getRelationsByCompanyId(String idCompany) {
        return relationHelper.transformFromEntitytoModel(repository.findByIdEmpresa(idCompany));
    }
    
    private StudentEventCompanyRelationEntity saveRelation(Company company, Student student, Event event) {
        Date date =  new Date();
        StudentEventCompanyRelationEntity relation = new StudentEventCompanyRelationEntity();
        relation.setIdAlumno(student.getId());
        relation.setIdEmpresa(company.getIdEmpresa());
        relation.setIdEvento(event.getIdEvento());
        relation.setFechaRelacion(date);
        return repository.save(relation);
    }
    
    private StudentEventCompanyRelation buildStudentEventCompanyRelation(
            Company company, Student student, Event event
    ){
        StudentEventCompanyRelation relation = new StudentEventCompanyRelation();
        relation.setAlumno(student);
        relation.setEmpresa(company);
        relation.setFeriaEmpleo(event);
        return relation;
    }

    private Company getCompanyById(String id) {
        return companyService.getCompanyById(id);
    }

    private Event getEventById(String id) {
        return eventService.getEventById(id);
    }
    
    private Student getStudentById(String id) {
        return studentService.getStudentById(id);
    }
}
