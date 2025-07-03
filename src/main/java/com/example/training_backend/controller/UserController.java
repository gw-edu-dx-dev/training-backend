package com.example.training_backend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.training_backend.service.UserService;
import com.example.training_backend.dto.UserResponse;
import com.example.training_backend.dto.UserRequest;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "http://localhost:5173/")
public class UserController {

  private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

  // 【Training 3】ユーザー一覧取得API
  @GetMapping("/list")
  public List<UserResponse> getAllUsers() {
    return userService.getAllUsers();
  }

  // 【Training 4】新規ユーザー登録API
  @PostMapping("/register")
  public void registerUser(@RequestBody UserRequest userRequest) {
    userService.registerUser(userRequest);
  }
}