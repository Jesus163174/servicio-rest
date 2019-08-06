/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.springframework.samples.petclinic.appointment;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import org.springframework.samples.petclinic.model.Person;

/**
 *
 * @author donaldoherr
 */
@Entity
@Table(name = "users")
public class UserHelping  extends Person{
     @Column(name = "email", unique = true)    
    @NotEmpty
    @Email    
    private String email;

    @Column(name = "password")
    @NotEmpty
    private String password;

    @Column(name = "telephone")
    @Size(min = 0, max = 10)
    private String telephone;

    @Column(name = "active")
    @NotEmpty
    @Max(1)
    private String active;

    @Column(name = "zipcode")
    @NotEmpty
    @Size(min = 5, max = 10)
    private String zipcode;

    @Column(name = "city")
    @NotEmpty
    private String city;
    
    @Column(name="first_name")
    @NotEmpty
    private String firstName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    
    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("User [id=").append(this.getId()).append(", firstName=").append(this.getFirstName()).append(", lastName=").append(this.getLastName()).
                append(", email=").append(email).append(", password=").append(password).append(", enabled=").append("true").append(", secret=").
                append(", city=").append(city).
                append(", zipcode=").append(zipcode)
                .append("]");
        return builder.toString();
    }
}
