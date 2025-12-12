package com.example.training_backend.dto;

public class LoginRequest {
    private long id;
    private String password;
    

    public LoginRequest(){
    }

    public LoginRequest(long id, String password){
        this.password = password;
        this.id = id;
    }

    public long getId(){
        return id;
    }

    public String getPassword(){
        return password;
    }

}
