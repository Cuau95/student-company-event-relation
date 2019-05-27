package com.example.student.company.event.relation.infrastruture.controller;

import com.example.student.company.event.relation.domain.model.StudentEventCompanyRelation;
import com.example.student.company.event.relation.domain.service.StudentEventCompanyRelationService;
import org.springframework.http.HttpStatus;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.OK;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student-company-event-relation")
public class StudentEventCompanyRelationController {
    
    private StudentEventCompanyRelationService service;

    public StudentEventCompanyRelationController(StudentEventCompanyRelationService service) {
        this.service = service;
    }
    
    @PostMapping("/student/{idStudent}/company/id/{idCompany}/event/id/{idEvent}")
    public ResponseEntity<StudentEventCompanyRelation> saveStudentEventCompanyRelation(
            @PathVariable String idStudent, @PathVariable String idCompany, @PathVariable String idEvent
    ) {
        StudentEventCompanyRelation relationSaved = service.saveStudentEventCompanyRelation(
                idStudent, idCompany, idEvent
        );
        HttpStatus status = OK;
        if(
                relationSaved.getAlumno() == null 
                || relationSaved.getEmpresa() == null 
                || relationSaved.getFeriaEmpleo() == null
           ){
            status = NOT_FOUND;
        }
        return new ResponseEntity<>(relationSaved, status);
    }
    
    @GetMapping("/company/{idCompany}")
    public ResponseEntity<String> getRelationByCompanyId(@PathVariable String idCompany){
        service.getRelationsByCompanyId(idCompany);
        return new ResponseEntity<>("nice", OK);
    }
    
}
