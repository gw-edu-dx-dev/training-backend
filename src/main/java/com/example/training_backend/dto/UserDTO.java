package com.example.training_backend.dto;

//フィールド
public class UserDTO {
    private Long id;
    private String name;
    private String email;
//デフォルトコンストラクタ
public UserDTO(){

}
//コンストラクタ
public UserDTO(Long id, String name, String email) {
    this.id = id;
    this.name = name;
    this.email = email;
}
//ゲッター
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