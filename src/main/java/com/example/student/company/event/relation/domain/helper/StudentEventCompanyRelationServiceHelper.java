package com.example.student.company.event.relation.domain.helper;

import com.example.student.company.event.relation.domain.model.StudentEventCompanyRelation;
import com.example.student.company.event.relation.domain.model.StudentEventCompanyRelationEntity;
import com.example.student.company.event.relation.domain.service.CompanyService;
import com.example.student.company.event.relation.domain.service.EventService;
import com.example.student.company.event.relation.domain.service.StudentService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StudentEventCompanyRelationServiceHelper {
    
    private CompanyService companyService;
    private EventService eventService;
    private StudentService studentService;

    @Autowired
    public StudentEventCompanyRelationServiceHelper(CompanyService companyService, EventService eventService, StudentService studentService) {
        this.companyService = companyService;
        this.eventService = eventService;
        this.studentService = studentService;
    }
    
    public List<StudentEventCompanyRelation> transformFromEntitytoModel(
            List<StudentEventCompanyRelationEntity> listEntities
    ) {
        List<StudentEventCompanyRelation> modelList = new ArrayList<>();
        listEntities.forEach( entity -> {
            StudentEventCompanyRelation model = new StudentEventCompanyRelation();
            model.setFecha(entity.getFechaRelacion());
            model.setAlumno(studentService.getStudentById(entity.getIdAlumno()));
            model.setEmpresa(companyService.getCompanyById(entity.getIdEmpresa()));
            model.setFeriaEmpleo(eventService.getEventById(Integer.toString(entity.getIdEvento())));
            model.setIdRelacion(entity.getIdRelacion());
            modelList.add(model);
        } );
        return modelList;
    }
    
}
