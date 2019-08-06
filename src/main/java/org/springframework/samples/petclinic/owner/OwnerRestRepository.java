/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.springframework.samples.petclinic.owner;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.samples.petclinic.appointment.UserHelping;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author donaldoherr
 */
public interface OwnerRestRepository extends Repository<OwnerRest, Integer>{
    
    
    @Query("SELECT owner FROM OwnerRest owner ")
    @Transactional(readOnly = true)
    ArrayList<OwnerRest> All();
    
    @Query("SELECT user from UserHelping user where user.email = :email")
    ArrayList<UserHelping> getByEmailUser(@Param("email") String email);
    
    @Query("SELECT owner FROM OwnerRest owner where owner.user_id =:iduser")
    OwnerRest getOwnerByIdUser(@Param("iduser") String iduser);
}
