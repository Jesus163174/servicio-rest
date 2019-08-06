/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.springframework.samples.petclinic.citasrest;

import java.util.Collection;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.samples.petclinic.citas.Citas;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author donaldoherr
 */
public interface TypeRepository extends Repository<TypeModel,Long>{
    
    @Query("SELECT type FROM TypeModel type")
    @Transactional(readOnly = true)
    Collection<TypeModel> findById();
    
}
