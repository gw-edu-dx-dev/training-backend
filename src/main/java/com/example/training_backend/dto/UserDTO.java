package com.example.training_backend.dto;

public class UserDTO{
    private Long id;
    private String name;
    private String email;
    private String password;

    //引数なし
    public UserDTO(){

    }

    //コンストラクタ, getter, setter
    public UserDTO(Long id, String name, String email, String password){
    this.id = id;
    this.name = name;
    this.email = email;
    this.password = password;
    }

    public Long getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getEmail(){
        return email;
    }

    public String getPassword(){
        return password;
    }

}
