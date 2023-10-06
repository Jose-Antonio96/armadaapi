package com.armada.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.armada.models.Soldado;
import com.armada.services.SoldadoService;

import jakarta.websocket.server.PathParam;

import org.springframework.http.MediaType;

@RestController
public class SoldadoController {
    @Autowired
    SoldadoService service;

    @GetMapping(value = "soldados", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<String> getSoldados(@PathParam("planeta") String planeta) {
        return service.getSoldadoPlaneta(planeta);
    }

    @PostMapping(value = "soldado", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void crearSoldado(@RequestBody Soldado soldado){
    
        service.nuevoSoldado(soldado);
    }
}

