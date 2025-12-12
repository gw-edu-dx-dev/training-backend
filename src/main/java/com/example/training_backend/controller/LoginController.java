package com.example.training_backend.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.training_backend.dto.LoginRequest;
import com.example.training_backend.dto.LoginResponse;
import com.example.training_backend.entity.User;
import com.example.training_backend.repository.UserRepository;
import com.example.training_backend.service.LoginService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5173")
public class LoginController {
    private final LoginService loginService;

    public LoginController(LoginService loginService){
        this.loginService = loginService;
    }

    // ログイン判定
    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request){
        return loginService.login(request.getId(), request.getPassword());
    }
}
