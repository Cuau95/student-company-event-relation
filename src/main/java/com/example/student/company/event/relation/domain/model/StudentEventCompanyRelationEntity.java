package com.example.student.company.event.relation.domain.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity
@Table(name = "alumno_empresa_relacion")
public class StudentEventCompanyRelationEntity implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRelacion;
    private String idAlumno;
    private String idEmpresa;
    private int idEvento;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaRelacion;

    public int getIdRelacion() {
        return idRelacion;
    }

    public void setIdRelacion(int idRelacion) {
        this.idRelacion = idRelacion;
    }

    public String getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(String idAlumno) {
        this.idAlumno = idAlumno;
    }

    public String getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(String idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public int getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }

    public Date getFechaRelacion() {
        return fechaRelacion;
    }

    public void setFechaRelacion(Date fechaRelacion) {
        this.fechaRelacion = fechaRelacion;
    }
    
}
