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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author usuario
 */
@RestController
public class TypesRestController {
   
    private final TypeRepository types;

    public TypesRestController(TypeRepository types) {
        this.types = types;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/api/types")
    public Map getTypes(){
        Collection<TypeModel> typesB = this.types.findById();
        HashMap<String, Collection<TypeModel>> map = new HashMap<>();
        map.put("mascotas",typesB);
        return map;
    }
    
}
