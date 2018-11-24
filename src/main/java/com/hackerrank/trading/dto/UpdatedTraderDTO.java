package com.hackerrank.trading.dto;

public class UpdatedTraderDTO {
    private  String name;
    private  String email;
    
    public UpdatedTraderDTO(String name, String email) {
        this.name = name;
        this.email = email;
    }
    public UpdatedTraderDTO(){

    }
    public String getName() {
        return this.name;
    }
    
    public String getEmail() {
        return this.email;
    }
}
