package com.example.training_backend.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.training_backend.dto.UserDTO;
import com.example.training_backend.dto.LoginRequest; 
import com.example.training_backend.entity.UserEntity;
import com.example.training_backend.repository.UserRepository;

//ユーザー関連のAPIを提供するコントローラー
@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:5173")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    //全ユーザー一覧を取得するAPI
    @GetMapping
    public List<UserEntity> getUsers() {
        return userRepository.findAll();
    }

    //新規ユーザーを登録するAPI
    @PostMapping
    public String createUser(@RequestBody UserDTO userDto) {
        UserEntity user = new UserEntity();
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        userRepository.save(user);
        return "ユーザー 「" + user.getName() + "」 をDBに登録しました！";
    }

    //ログイン認証用API
    @PostMapping("/login")
    public String login(@RequestBody LoginRequest loginRequest) {
        //ユーザーIDとパスワードが一致するユーザーを検索
        return userRepository.findAll().stream()
            .filter(user -> user.getName().equals(loginRequest.getUserId()) 
            && user.getPassword().equals(loginRequest.getPassword()))
            .findFirst()
            .map(user -> "OK") 
            .orElse("NG");
    }
} 