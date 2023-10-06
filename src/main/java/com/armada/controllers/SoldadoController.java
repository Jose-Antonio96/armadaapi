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

    /**
     * Esta función de Java devuelve una lista de soldados de un planeta específico en formato JSON.
     * 
     * @param planeta El parámetro "planeta" es una cadena que representa el nombre de un planeta.
     * @return El método devuelve una lista de cadenas.
     */
    @GetMapping(value = "soldados", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<String> getSoldados(@PathParam("planeta") String planeta) {
        return service.getSoldadoPlaneta(planeta);
    }

    /**
     * Esta función de Java crea un nuevo soldado aceptando un objeto JSON como entrada y llamando a un
     * método de servicio para salvar al soldado.
     * 
     * @param soldado El parámetro "soldado" es de tipo "Soldado" y está anotado con "@RequestBody".
     * Representa el cuerpo de la solicitud JSON que se convertirá en un objeto "Soldado" y se pasará
     * al método "nuevoSoldado" del objeto "servicio".
     */
    @PostMapping(value = "soldado", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void crearSoldado(@RequestBody Soldado soldado){
    
        service.nuevoSoldado(soldado);
    }
}

