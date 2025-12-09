package com.example.training_backend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.training_backend.dto.CreateUserRequest;
import com.example.training_backend.dto.UserDto;
import com.example.training_backend.service.UserService;


@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:5173") //Reactからのアクセスを許可する
public class UserListController {
    
    private final UserService userService;

    public UserListController(UserService userService){
        this.userService = userService;
    }
    @GetMapping
    public List<UserDto> getUsers(){
        return userService.getAllUsers(); //DBから取得
    }

    // 新規登録
    @PostMapping
    public UserDto createUser(@RequestBody CreateUserRequest request){ //@RequestBody:HTTPリクエスト本文に含まれているデータを引数として受け取る
        return userService.createUser(request); //DBに保存
    }
}
