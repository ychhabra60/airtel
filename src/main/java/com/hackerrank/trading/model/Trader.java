package com.hackerrank.trading.model;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Trader implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String name;
    private String email;
    
    private Float balance;
    
    private Timestamp created_at;
    private Timestamp modified_at;

    public Trader() {
    }
    
    public Trader(String name, String email, Float balance) {
        this.name = name;
        this.email = email;
        this.balance = balance;
    }
    
    public Long getId() {
        return this.id;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public Float getBalance() {
        return this.balance;
    }
    
    public void setBalance(Float balance) {
        this.balance = balance;
    }
    
    public Timestamp getCreated_at() {
        return this.created_at;
    }
    
    public Timestamp getModified_at() {
        return this.modified_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public void setModified_at(Timestamp modified_at) {
        this.modified_at = modified_at;
    }
}
