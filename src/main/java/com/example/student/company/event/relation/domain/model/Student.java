package com.example.student.company.event.relation.domain.model;

import java.io.Serializable;

public class Student implements Serializable {
    
    private String id;
    private String nombreAlumno;
    private String pApellido;
    private String mApellido;
    private String nombreCompleto;
    private Campus campus;
    private Career career;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombreAlumno() {
        return nombreAlumno;
    }

    public void setNombreAlumno(String nombreAlumno) {
        this.nombreAlumno = nombreAlumno;
    }

    public String getpApellido() {
        return pApellido;
    }

    public void setpApellido(String pApellido) {
        this.pApellido = pApellido;
    }

    public String getmApellido() {
        return mApellido;
    }

    public void setmApellido(String mApellido) {
        this.mApellido = mApellido;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public Campus getCampus() {
        return campus;
    }

    public void setCampus(Campus campus) {
        this.campus = campus;
    }

    public Career getCareer() {
        return career;
    }

    public void setCareer(Career career) {
        this.career = career;
    }
        public class Campus implements Serializable {

        private int idEscuela;
        private String nombreEscuela;
        
        public int getIdEscuela() {
            return idEscuela;
        }

        public void setIdEscuela(int idEscuela) {
            this.idEscuela = idEscuela;
        }

        public String getNombreEscuela() {
            return nombreEscuela;
        }

        public void setNombreEscuela(String nombreEscuela) {
            this.nombreEscuela = nombreEscuela;
        }
        
    }

    public class Career implements Serializable {

        private int idCarrera;
        private String nombreCarrera;

        public int getIdCarrera() {
            return idCarrera;
        }

        public void setIdCarrera(int idCarrera) {
            this.idCarrera = idCarrera;
        }

        public String getNombreCarrera() {
            return nombreCarrera;
        }

        public void setNombreCarrera(String nombreCarrera) {
            this.nombreCarrera = nombreCarrera;
        }
        
    }
}
