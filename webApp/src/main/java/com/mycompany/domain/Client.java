package com.mycompany.domain;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Client {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    private String email;
    private String phone;
    private String address;
    private String PNC; // personal numeric code

    @Column(name = "id_card_nr")
    private String idCardNr;
    
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name="customer_account", 
                joinColumns={@JoinColumn(name="idcustomer")}, 
                inverseJoinColumns={@JoinColumn(name="idaccount")})
    private Set<Account> accounts = new HashSet<>(0);

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPNC() {
        return PNC;
    }

    public void setPNC(String PNC) {
        this.PNC = PNC;
    }

    public String getIdCardNr() {
        return idCardNr;
    }

    public void setIdCardNr(String idCardNr) {
        this.idCardNr = idCardNr;
    }

}
