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
