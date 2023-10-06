package com.armada.services;

import java.util.List;

import com.armada.models.Soldado;

public interface SoldadoService {
    
    public List<String> getSoldadoPlaneta(String planeta);

    void nuevoSoldado(Soldado soldado);

}
