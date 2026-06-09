package com.example.training_backend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.training_backend.dto.UserDTO;
import com.example.training_backend.repository.UserRepository;
import com.example.training_backend.repository.entity.User;

@RestController
@RequestMapping("/api/users")
//viteにつながるようにするための設定
@CrossOrigin(origins = "http://localhost:5173")
public class UserController {
//finalの意味合いは後で変更できないという意味合い
//userRepositryは一度セットしたら別のRepositoryに変更できない
     private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    //getMappingでuserのリストからすべてを表示する
    @GetMapping
    public List<User> getUsers() {
        return userRepository.findAll();
    }
    //training4
    @PostMapping
    public String createUser(@RequestBody UserDTO userDTO) {

        User user = new User(
        userDTO.getName(),
        userDTO.getEmail()
    );
    userRepository.save(user);


        return "ユーザー " + userDTO.getName() + " が作成されました";
    }
    
}
