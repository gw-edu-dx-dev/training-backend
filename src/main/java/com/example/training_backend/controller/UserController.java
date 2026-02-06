package com.example.training_backend.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.training_backend.dto.UserDTO;
import com.example.training_backend.entity.UserEntity; // Entityをインポート
import com.example.training_backend.repository.UserRepository; // Repositoryをインポート

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:5173")
public class UserController {

    @Autowired
    private UserRepository userRepository; // データベース操作用のツールを注入

    // Training 5: データベースから全ユーザーを取得
    @GetMapping
    public List<UserEntity> getUsers() {
        return userRepository.findAll(); // SQLを書かなくても自動で全件取得してくれます
    }

    // Training 5: 新しいユーザーをデータベースに保存
    @PostMapping
    public String createUser(@RequestBody UserDTO userDto) {
        // DTOからEntityにデータを詰め替える
        UserEntity user = new UserEntity();
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());

        // データベースに保存
        userRepository.save(user);

        System.out.println("DBに保存しました: " + user.getName());
        return "ユーザー 「" + user.getName() + "」 をDBに登録しました！";
    }
}