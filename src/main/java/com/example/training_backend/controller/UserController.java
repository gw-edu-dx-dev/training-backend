package com.example.training_backend.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.training_backend.dto.UserDTO;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:5173")
public class UserController {
    
    //training3
    // GETリクエストでユーザー一覧を返す
    @GetMapping
    public List<UserDTO> getUsers() {
        // ダミーユーザー作成
        UserDTO user1 = new UserDTO(1L, "DO THU HUYEN", "Huyenboo2k@gmail.com");
        UserDTO user2 = new UserDTO(2L, "あかり", "Akari@gmail.com");
        UserDTO user3 = new UserDTO(3L, "鈴木", "suzuki@gmail.com");
        
        // ユーザー一覧を返す
        return Arrays.asList(user1, user2, user3);
    }

    //Training4 
// POSTリクエストで新しいユーザーを受け取る
    @PostMapping
    public String createUser(@RequestBody UserDTO userDto) {
        // 受信したデータを確認するためにコンソールに出力
        System.out.println("新しいユーザーを受信");
        System.out.println("名前: " + userDto.getName());
        System.out.println("メール: " + userDto.getEmail());
        
        // Reactに表示するためのメッセージを返す
        return "ユーザー 「" + userDto.getName() + "」 を登録しました！";
    }
    
}
