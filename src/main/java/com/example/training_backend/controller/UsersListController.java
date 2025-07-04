package com.example.training_backend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.training_backend.dto.UserResponse;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5173/")
public class UsersListController {
    @GetMapping("/UsersList")
    public List<UserResponse> getUsersList() {
        return List.of(
      new UserResponse(1L, "田中 太郎", "tanaka@example.com"),
      new UserResponse(2L, "山田 花子", "yamada@example.com"),
      new UserResponse(3L, "鈴木 次郎", "suzuki@example.com")
    );
    }
}