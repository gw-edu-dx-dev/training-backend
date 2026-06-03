package com.example.training_backend.controller;

import java.util.List;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.training_backend.dto.UserDTO;

@RestController
@RequestMapping("/api/users")
//viteにつながるようにするための設定
@CrossOrigin(origins = "http://localhost:5173")
public class UserController {
    @GetMapping
    public List<UserDTO> getUsers() {
        UserDTO user1 = new UserDTO(1L, "青山", "aoyama@gmail.com");
        UserDTO user2 = new UserDTO(2L, "櫻井", "sakurai@gmail.com");
        UserDTO user3 = new UserDTO(3L, "鈴木", "suzuki@gmail.com");
        
        // ユーザー一覧を返す

        List<UserDTO> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);
        return users;
    }
}
