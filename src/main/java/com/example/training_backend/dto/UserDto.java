package com.example.training_backend.dto;

// ユーザー情報をReactに渡すためだけに使う箱（データ転送専用クラス）
// Entityと違って、「画面に返したい情報だけ」を入れるのが目的
// Java→JSONを作るための設計図
public class UserDto {
    
    private Long id;
    private String name;
    private String email;

    public UserDto(){

    }

    public UserDto(Long id, String name, String email){
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
    
}
