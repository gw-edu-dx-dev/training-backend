package com.example.training_backend.dto;

public class LoginRequest {
    private String userId; 
    private String password; 

    public LoginRequest() {}


    //getter,setter
    public String getUserId() {
        return userId; 
    }
    public void setUserId(String userId) { 
        this.userId = userId; 
    }

    public String getPassword() {
        return password; 
    }
    public void setPassword(String password) { 
        this.password = password; 
    }
}