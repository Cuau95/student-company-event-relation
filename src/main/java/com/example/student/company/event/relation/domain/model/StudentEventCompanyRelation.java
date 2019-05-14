package com.example.student.company.event.relation.domain.model;

import java.io.Serializable;
import java.util.Date;

public class StudentEventCompanyRelation implements Serializable{
    
    private int idRelacion;
    private Student alumno;
    private Company empresa;
    private Event feriaEmpleo;
    private Date fecha;
    
}
