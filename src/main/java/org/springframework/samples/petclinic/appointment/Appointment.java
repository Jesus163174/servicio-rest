package org.springframework.samples.petclinic.appointment;

import java.sql.Date;
import java.sql.Time;
import java.util.Set;
import javax.persistence.Column;
import org.springframework.samples.petclinic.model.BaseEntity;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.samples.petclinic.owner.Owner;

@Entity
@Table(name = "citas")

public class Appointment extends BaseEntity {

    @Column(name = "owner_id")
    @NotEmpty
    private String owner_id;


    @Column(name = "fecha")
    @NotEmpty
    private String fecha;


    @Column(name = "hora")
    @NotEmpty
    private String hora;


    @Column(name = "mascota")
    @NotEmpty
    private String mascota;


    @Column(name = "especialidad")
    @NotEmpty
    private String especialidad;


    @Column(name = "confirmacion")
    @NotEmpty
    private String confirmacion;
	   
	
    public String getOwner_id() {

        return owner_id;
    }
	
    public void setOwner_id(String owner_id) {

        this.owner_id = owner_id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setHora(String hora) {

        this.hora = hora;
    }

    public String getHora() {

        return hora;
    }
	
    public String getMascota() {
    
        return mascota;
    }
	
    public void setMascota(String pet) {
   
        this.mascota = pet;
    }
	
    public String getEspecialidad() {
    
        return especialidad;
    }
	
    public void setEspecialidad(String especialidad) {
   
        this.especialidad = especialidad;
    }
	
    public String getConfirmacion() {
   
        return confirmacion;
    }
	
    public void setConfirmacion(String confirmacion){
        this.confirmacion = confirmacion;
    }

}
