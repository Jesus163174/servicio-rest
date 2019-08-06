/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.springframework.samples.petclinic.citasrest;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.springframework.samples.petclinic.citas.Especialidades;
import org.springframework.samples.petclinic.citas.Mascotas;
import org.springframework.samples.petclinic.citas.MascotasRepository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author donaldoherr
 */
@RestController
public class MascotasRestController {
    
    private final MascotasRepository mascotas;
    
    public MascotasRestController(MascotasRepository mascotas){
        this.mascotas = mascotas;
    }
    @RequestMapping(method = RequestMethod.GET, path = "/api/mascotas/{owner_id}")
    public Map getMascotasByOwner(@PathVariable("owner_id") int owner_id){
        Collection<Mascotas> mascotasCollection = this.mascotas.getMascotaByOwner(owner_id);
        Map<String, Collection<Mascotas>> map = new HashMap<>();
        map.put("mascotas", mascotasCollection);
        return map;
    }
    
    @RequestMapping(method = RequestMethod.GET, path = "/api/mascotas/byid/{id}")
    public Map getMascotasById(@PathVariable("id") int id){
        Collection<Mascotas> mascotasCollection = this.mascotas.getOnlyMascotas(id);
        Map<String, Collection<Mascotas>> map = new HashMap<>();
        map.put("mascotas", mascotasCollection);
        return map;
    }
    
}
