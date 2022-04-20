package com.indigoGrafica.models;

import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "person")
@Access(AccessType.FIELD)
public class Person extends ParentEntity{

    private static final long serialVersionUID = 22879444961260451L;


    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "birthdate")
    private Date birthdate;

    @NaturalId
    @Column(name = "cuit")
    private Long cuit;

    @Column(name = "email")
    private String email;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public Long getCuit() {
        return cuit;
    }

    public void setCuit(Long cuit) {
        this.cuit = cuit;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void assign(Person p) {
        this.setCuit(p.getCuit());
        this.setBirthdate(p.getBirthdate());
        this.setEmail(p.getEmail());
        this.setFirstName(p.getFirstName());
        this.setLastName(p.getLastName());
    }
}