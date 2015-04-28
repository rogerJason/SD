package com.cb.domain;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Patient {

    @Id
    @GeneratedValue
    @Column(name = "patient_id")
    private int id;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "id_card_nr")
    private String idCardNr;

    private String PNC; // personal numeric code

    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    private String address;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "patient")
    private Set<Consultation> consultation = new HashSet<>(0);

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public String getIdCardNr() {
        return idCardNr;
    }

    public void setIdCardNr(String idCardNr) {
        this.idCardNr = idCardNr;
    }

    public String getPNC() {
        return PNC;
    }

    public void setPNC(String PNC) {
        this.PNC = PNC;
    }
    
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
