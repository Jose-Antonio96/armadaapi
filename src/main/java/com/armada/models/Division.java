package com.armada.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "divisiones")
public class Division {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int codDivision;
    private String division;

    @OneToMany(mappedBy = "division")
    private List<Clon> clones = new ArrayList<>();

    public Division(){
        super();
    }
    
    public Division(int codDivision, String division) {
        super();
        this.codDivision = codDivision;
        this.division = division;
    }

    public int getCodDivision() {
        return codDivision;
    }

    public void setCodDivision(int codDivision) {
        this.codDivision = codDivision;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    
}