package com.hackerrank.trading.dto;

public class AddMoneyTraderDTO {
    private final String email;
    private final Float amount;
    
    public AddMoneyTraderDTO(String email, Float amount) {
        this.email = email;
        this.amount = amount;
    }
    
    public String getEmail() {
        return this.email;
    }
    
    public Float getAmount() {
        return this.amount;
    }
}
