package com.example.training_backend.dto;

public class LoginResponse {
    private boolean success;
    private String message;

    public LoginResponse(){
    }

    public LoginResponse(boolean success, String message){
        this.success = success;
        this.message = message;
    }

    public boolean isSuccess(){
        return success;
    }

    public String getMessage(){
        return message;
    }
}
