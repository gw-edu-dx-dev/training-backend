package com.example.training_backend.dto;

public class CreateUserRequest {
    private String name;
    private String email;
    private String password;
    private Long id;
    

    public CreateUserRequest(){}

    public CreateUserRequest(Long id,String name,String email,String password){
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Long getId(){
        return id;
    }

    public String getPassword(){
        return password;
    }
    
}
