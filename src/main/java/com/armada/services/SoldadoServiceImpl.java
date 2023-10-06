package com.armada.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

import com.armada.models.Soldado;
import com.armada.models.Clon;
import com.armada.models.Division;
import com.armada.models.Planeta;

@Service
public class SoldadoServiceImpl implements SoldadoService {
    @Autowired
    RestTemplate template;

    private String url = "http://localhost:8080/";

    
    /**
     * La función "getSoldadoPlaneta" devuelve una lista de nombres de clones que pertenecen a un
     * planeta específico.
     * 
     * @param planeta El parámetro "planeta" es un String que representa el nombre de un planeta.
     * @return El método devuelve una lista de cadenas que contiene los nombres de los clones que
     * pertenecen al planeta especificado.
     */
    @Override
    public List<String> getSoldadoPlaneta(String planeta) {
        List<String> listaNombresClones = new ArrayList<>();

        ResponseEntity<Clon[]> response = template.exchange(url + "clones", HttpMethod.GET, null,
                Clon[].class);
        List<Clon> listaClon = Arrays.asList(response.getBody());

        for (Clon clon : listaClon) {
            if (clon.getPlaneta().equals(planeta)) {
                listaNombresClones.add(clon.getNombre());
            }
        }

        return listaNombresClones;
    }

    /**
     * La función `nuevoSoldado` verifica si un soldado ya existe en una lista de clones y agrega al
     * soldado como un nuevo clon si no existe.
     * 
     * @param soldado El parámetro "soldado" es un objeto de tipo "Soldado". Contiene información sobre
     * un soldado, como su nombre, división y planeta.
     */
    @Override
    public void nuevoSoldado(Soldado soldado) {
        boolean existe = false;
        ResponseEntity<Clon[]> response = template.exchange(url + "clones", HttpMethod.GET, null, Clon[].class);
        List<Clon> listaClon = Arrays.asList(response.getBody());

        for (Clon clon : listaClon) {
            if (clon.getNombre().equals(soldado.getClonName())) {
                existe = true;
            }
        }

        if (!existe) {

            template.postForLocation(url + "clon", new Clon(0, soldado.getClonName(), soldado.getDivision(), soldado.getPlaneta()));
        }
    }
}
