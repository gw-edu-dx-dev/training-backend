package com.example.training_backend.controller;

import java.util.List;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.training_backend.dto.UserDTO;

@RestController
@RequestMapping("/api/users")
//viteにつながるようにするための設定
@CrossOrigin(origins = "http://localhost:5173")
public class UserController {
    @GetMapping
    public List<UserDTO> getUsers() {
        UserDTO user1 = new UserDTO(1L, "青山知弘", "aoyama@gmail.com");
        UserDTO user2 = new UserDTO(2L, "櫻井翔", "sakurai@gmail.com");
        UserDTO user3 = new UserDTO(3L, "白草四音", "shirakusa@gmail.com");
        UserDTO user4 = new UserDTO(4L, "十王星南", "juo@gmail.com");
        UserDTO user5 = new UserDTO(5L, "松本潤" ,"matsumoto@gmail.com");
        UserDTO user6 = new UserDTO(6L, "白石晴香" , "shiraishi@gmail.com");
        
        // ユーザー一覧を返す

        List<UserDTO> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        users.add(user5);
        users.add(user6);
        return users;
    }
    //training4
    @PostMapping
    public String createUser(@RequestBody UserDTO userDTO) {

        System.out.println("名前:"+ userDTO.getName());
        System.out.println("メール:"+ userDTO.getEmail());

        return "ユーザー " + userDTO.getName() + " が作成されました";
    }
}
