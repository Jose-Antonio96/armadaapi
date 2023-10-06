package com.armada.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "planetas")
public class Planeta {
    @Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int codPlaneta;
    private String planeta;

    @OneToMany(mappedBy = "planeta")
    private List<Clon> clones = new ArrayList<>();


    public Planeta() {
        super();
    }

    public Planeta(int codPlaneta, String planeta) {
        super();
        this.codPlaneta = codPlaneta;
        this.planeta = planeta;
    }

    public int getCodPlaneta() {
        return codPlaneta;
    }

    public void setCodPlaneta(int codPlaneta) {
        this.codPlaneta = codPlaneta;
    }

    public String getPlaneta() {
        return planeta;
    }

    public void setPlaneta(String planeta) {
        this.planeta = planeta;
    }
}