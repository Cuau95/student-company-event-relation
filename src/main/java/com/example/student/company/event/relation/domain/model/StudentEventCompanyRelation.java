package com.example.student.company.event.relation.domain.model;

import java.io.Serializable;
import java.util.Date;

public class StudentEventCompanyRelation implements Serializable{
    
    private int idRelacion;
    private Student alumno;
    private Company empresa;
    private Event feriaEmpleo;
    private Date fecha;

    public int getIdRelacion() {
        return idRelacion;
    }

    public void setIdRelacion(int idRelacion) {
        this.idRelacion = idRelacion;
    }

    public Student getAlumno() {
        return alumno;
    }

    public void setAlumno(Student alumno) {
        this.alumno = alumno;
    }

    public Company getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Company empresa) {
        this.empresa = empresa;
    }

    public Event getFeriaEmpleo() {
        return feriaEmpleo;
    }

    public void setFeriaEmpleo(Event feriaEmpleo) {
        this.feriaEmpleo = feriaEmpleo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
}
