/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.springframework.samples.petclinic.owner;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import static org.hibernate.internal.util.collections.CollectionHelper.arrayList;
import org.springframework.samples.petclinic.appointment.Appointment;
import org.springframework.samples.petclinic.appointment.UserHelping;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author donaldoherr
 */
@RestController
public class OwnerRestController {
    
    OwnerRestRepository owners;
    private PasswordEncoder pass;
    public OwnerRestController(OwnerRestRepository owners){
        this.owners =  owners;
    }
    
    @RequestMapping(method = RequestMethod.GET, path = "/api/owner/{userID}")
    public Map getCita(@PathVariable("userID") String userID) {
        HashMap<String, String> map = new HashMap<>();
        OwnerRest owner = this.owners.getOwnerByIdUser(userID);
        map.put("owner",String.valueOf(owner.getId()));
        return map;
    }
    
    
    @RequestMapping(method = RequestMethod.POST, path = "/api/owners/login")
    public Map login(@RequestBody UserHelping userHelping) {
        String email = userHelping.getEmail();
        String password = userHelping.getPassword();
        ArrayList<UserHelping> userData = this.owners.getByEmailUser(email);
        String pass = null;
        Integer id = null;
        String name = null;
        for(UserHelping user : userData){
            pass = user.getPassword();
            id   = user.getId();
            name = user.getFirstName();
        }
        String [] strPass = pass.split("}");
        BCryptPasswordEncoder b = new BCryptPasswordEncoder();
        HashMap<String, String> map = new HashMap<>();
        if(b.matches(password,  strPass[1]) == false){
            map.put("response", "0");
            return map;
        }else{
            map.put("response","1");
            map.put("name",name);
            map.put("userId",""+id);
            return map;
        }
    }
    /*@RequestMapping(method = RequestMethod.GET, path = "/api/owners/{owner}")
    public Appointment getCita(@PathVariable("citaID") int citaID) {
      
    }*/
    
    
    
    
    
}
