package com.example.training_backend.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.training_backend.dto.UserDto;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:5173")
public class UserListController {
    
    @GetMapping
    public List<UserDto> getUsers(){
        UserDto user1 = new UserDto(1L, "山田太郎" ,"yamada@example.com" );
        UserDto user2 = new UserDto(2L, "鈴木花子", "suzuki2@example.com");
    
        return Arrays.asList(user1, user2);
    }
}
