package com.armada.models;

import jakarta.persistence.*;

@Entity
@Table(name = "clones")
public class Clon {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int codClon;
    private String nombre;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cod_division", referencedColumnName = "codDivision") 
    private Division division;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cod_planeta", referencedColumnName = "codPlaneta") 
    private Planeta planeta;

    public Clon() {
        super();
    }

    public Clon(int codClon, String nombre, Division division, Planeta planeta) {
        super();
        this.codClon = codClon;
        this.nombre = nombre;
        this.division = division;
        this.planeta = planeta;
    }

    public int getCodClon() {
        return codClon;
    }

    public void setCodClon(int codClon) {
        this.codClon = codClon;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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