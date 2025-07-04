package com.example.training_backend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.training_backend.service.UserService;

import lombok.RequiredArgsConstructor;

import com.example.training_backend.dto.UserResponse;
import com.example.training_backend.dto.UserRequest;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
@CrossOrigin(origins = "http://localhost:5173/")
public class UserController {

  private final UserService userService;

  /**
   * 全ユーザー情報の取得API
   * 
   * @return 全ユーザー情報のリスト
   */
  @GetMapping("/list")
  public List<UserResponse> getAllUsers() {
    return userService.getAllUsers();
  }

  /**
   * 新規ユーザー登録API
   */
  @PostMapping("/register")
  public void registerUser(@RequestBody UserRequest userRequest) {
    userService.registerUser(userRequest);
  }
}