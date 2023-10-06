package com.armada.models;

import jakarta.persistence.*;

/**
 * La clase "Soldado" representa un soldado con nombre clon, asignado a una división y un planeta.
 */
public class Soldado {
    private String clonName;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cod_division", referencedColumnName = "codDivision") 
    private Division division;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cod_planeta", referencedColumnName = "codPlaneta") 
    private Planeta planeta;

    public Soldado(String clonName, Division division, Planeta planeta) {
        this.clonName = clonName;
        this.division = division;
        this.planeta = planeta;
    }


    public Soldado() {
        super();
    }



    public int obtenerCodDivision(Division division) {
        return division.getCodDivision();
    }
    
    public int obtenerCodPlaneta(Planeta planeta) {
        return planeta.getCodPlaneta();
    }


    public String getClonName() {
        return clonName;
    }





    public void setClonName(String clonName) {
        this.clonName = clonName;
    }





    public Division getDivision() {
        return division;
    }





    public void setDivision(Division division) {
        this.division = division;
    }





    public Planeta getPlaneta() {
        return planeta;
    }





    public void setPlaneta(Planeta planeta) {
        this.planeta = planeta;
    }
}
