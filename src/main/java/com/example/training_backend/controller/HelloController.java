package com.example.training_backend.controller;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import com.example.training_backend.dto.UserDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.example.training_backend.dto.RegisterUserDto;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5173")
public class HelloController {
    @GetMapping("/hello")
    public String sayHello(@RequestParam String name) {
        return "こんにちは" + name + "さん";
    }

    @GetMapping("/users")
    public List<UserDto> getUsers() {
        return List.of(
            new UserDto(1, "田中"),
            new UserDto(2, "佐藤"),
            new UserDto(3, "鈴木")
        );
    }

    @PostMapping("/register")
    public String registerUser(@RequestBody RegisterUserDto user) {

        System.out.println("名前：" + user.getName());
        System.out.println("ログインID：" + user.getLoginId());
        System.out.println("パスワード：" + user.getPassword());

        return "ユーザー情報を受け取りました";
    }
}
