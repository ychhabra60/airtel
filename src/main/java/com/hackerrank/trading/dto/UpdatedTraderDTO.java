package com.hackerrank.trading.dto;

public class UpdatedTraderDTO {
    private final String name;
    private final String email;
    
    public UpdatedTraderDTO(String name, String email) {
        this.name = name;
        this.email = email;
    }
    
    public String getName() {
        return this.name;
    }
    
    public String getEmail() {
        return this.email;
    }
}
