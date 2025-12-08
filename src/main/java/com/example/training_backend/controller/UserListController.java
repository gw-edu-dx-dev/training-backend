package com.example.training_backend.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.training_backend.dto.CreateUserRequest;
import com.example.training_backend.dto.UserDto;


@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:5173") //Reactからのアクセスを許可する
public class UserListController {
    
    // 起動中だけ保持する簡易DB
    private final List<UserDto> users = new ArrayList<>();
    private Long nextId = 1L; // 自動採番用

    // コンストラクタで初期データをセット
    public UserListController() {
        users.add(new UserDto(nextId++, "山田太郎", "yamada@example.com"));
        users.add(new UserDto(nextId++, "鈴木花子", "suzuki2@example.com"));
    }

    @GetMapping
    public List<UserDto> getUsers(){
        return users;
    }

    // 新規登録
    @PostMapping
    public UserDto createUser(@RequestBody CreateUserRequest request){ //@RequestBody:HTTPリクエスト本文に含まれているデータを引数として受け取る
       
        System.out.println("=== 新規ユーザー登録リクエストを受信しました ===");
        System.out.println("名前：" + request.getName());
        System.out.println("メール：" + request.getEmail());
        System.out.println("========================================");

        UserDto created = new UserDto(nextId++, request.getName(),request.getEmail() );
        users.add(created);

        // JSONで返す
        return created;
    }
}
