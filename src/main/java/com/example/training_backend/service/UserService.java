package com.example.training_backend.service;

import com.example.training_backend.dto.UserRequest;
import com.example.training_backend.dto.UserResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class UserService {

    private final AtomicLong counter = new AtomicLong();

    public List<UserResponse> getAllUsers() {
        return List.of(
            new UserResponse(1L, "田中 太郎", "tanaka@example.com"),
            new UserResponse(2L, "山田 花子", "yamada@example.com"),
            new UserResponse(3L, "鈴木 次郎", "suzuki@example.com")
        );
    }

    public void registerUser(UserRequest userRequest) {
        userRequest.setId(counter.incrementAndGet());
        System.out.println("ユーザー登録が完了しました。");
        System.out.println("ID: " + userRequest.getId());
        System.out.println("NAME: " + userRequest.getName());
        System.out.println("E-MAIL: " + userRequest.getEmail());
    }
}