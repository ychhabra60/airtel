package com.hackerrank.trading.dto;

public class AddMoneyTraderDTO {
    private  String email;
    private Float amount;
    
    public AddMoneyTraderDTO(String email, Float amount) {
        this.email = email;
        this.amount = amount;
    }
    public AddMoneyTraderDTO(){}
    public String getEmail() {
        return this.email;
    }
    
    public Float getAmount() {
        return this.amount;
    }
}
