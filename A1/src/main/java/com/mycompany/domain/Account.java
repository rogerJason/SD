package com.mycompany.domain;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Account {

    @Id
    @GeneratedValue
    @Column(name = "idaccount")
    private int idAccount;
    
    @Column(name = "IBAN")
    private String IBAN;

    @Column(name = "type")
    private String type;

    @Column(name = "balance")
    private int balance;

    @Column(name = "interest_rate")
    private String interestRate;

    @Column(name = "overdraft")
    private String overdraft;

    @Column(name = "last_access")
    private Timestamp lastAccess;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "account")
    private Set<CustomerAccount> customerAccount = new HashSet<>(0);

    public int getId() {
        return idAccount;
    }

    public void setId(int idAccount) {
        this.idAccount = idAccount;
    }
    
    public String getIBAN() {
        return IBAN;
    }

    public void setIBAN(String IBAN) {
        this.IBAN = IBAN;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(String interestRate) {
        this.interestRate = interestRate;
    }

    public String getOverdraft() {
        return overdraft;
    }

    public void setOverdraft(String overdraft) {
        this.overdraft = overdraft;
    }

    public Timestamp getLastAccess() {
        return lastAccess;
    }

    public void setLastAccess(Timestamp lastAccess) {
        this.lastAccess = lastAccess;
    }

}
