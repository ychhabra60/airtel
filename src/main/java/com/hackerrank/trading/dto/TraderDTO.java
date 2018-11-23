package com.hackerrank.trading.dto;

import com.hackerrank.trading.model.Trader;
import java.text.SimpleDateFormat;

public class TraderDTO {
    private final Long id;
    private final String name;
    private final String email;
    private final Float balance;
    
    private final String creationTime;
    private final String modificationTime;
    
    public TraderDTO(Trader trader) {
        this.id = trader.getId();
        this.name = trader.getName();
        this.email = trader.getEmail();
        this.balance = trader.getBalance();
        this.creationTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(trader.getCreationTime());
        this.modificationTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(trader.getModificationTime());
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
    
    public String getCreationTime() {
        return this.creationTime;
    }
    
    public String getModificationTime() {
        return this.modificationTime;
    }
}
