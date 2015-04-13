package com.mycompany.domain;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "customer_account", catalog = "springhibernate_db")
public class CustomerAccount {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;
    
    @Column(name = "idcustomer")
    private int idCustomer;

    @Column(name = "idaccount")
    private int idAccount;

    @Column(name = "creation")
    private Timestamp creation;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idcustomer", referencedColumnName = "id", insertable = false, updatable = false)
    private Client client;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idaccount", referencedColumnName = "idaccount", insertable = false, updatable = false)
    private Account account;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public int getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(int idAccount) {
        this.idAccount = idAccount;
    }

    public Timestamp getCreation() {
        return creation;
    }

    public void setCreation(Timestamp creation) {
        this.creation = creation;
    }

}
