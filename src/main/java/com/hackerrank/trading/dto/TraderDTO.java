package com.hackerrank.trading.dto;

import com.hackerrank.trading.model.Trader;
import java.text.SimpleDateFormat;

public class TraderDTO {
    private  Long id;
    private  String name;
    private String email;
    private  Float balance;
    
    private  String created_at;
    private  String updated_at;
    public TraderDTO(){}
    public TraderDTO(Trader trader) {
        this.id = trader.getId();
        this.name = trader.getName();
        this.email = trader.getEmail();
        this.balance = trader.getBalance();
        if(trader.getCreated_at()!=null)
        this.created_at = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(trader.getCreated_at());
        else this.created_at ="";
        if(trader.getModified_at()!=null)
        this.updated_at = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(trader.getModified_at());
        else this.updated_at ="";
    }
    
    public Long getId() {
        return this.id;
    }
    
    public String getName() {
        return this.name;
    }
    
    public String getEmail() {
        return this.email;
    }
    
    public Float getBalance() {
        return this.balance;
    }
    
    public String getCreated_at() {
        return this.created_at;
    }
    
    public String getUpdated_at() {
        return this.updated_at;
    }
}
