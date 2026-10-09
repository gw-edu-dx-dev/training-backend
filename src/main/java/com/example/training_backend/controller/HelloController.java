package com.example.training_backend.controller;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import com.example.training_backend.dto.UserDto;
import com.example.training_backend.repository.UserRepository;
import com.example.training_backend.entity.UserEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.example.training_backend.dto.RegisterUserDto;
import java.security.SecureRandom;
import java.util.Base64;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import com.example.training_backend.dto.LoginDto;
import java.security.MessageDigest;
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5173")
public class HelloController {
    private final UserRepository userRepository;

    public HelloController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/hello")
    public String sayHello(@RequestParam String name) {
        return "こんにちは" + name + "さん";
    }

    @GetMapping("/users")
    public List<UserDto> getUsers() {
        return userRepository.findAll()
        .stream()
        .map(user -> new UserDto(
            Math.toIntExact(user.getId()),
            user.getName()
        ))
        .toList();
}

    @PostMapping("/register")
    public String registerUser(@RequestBody RegisterUserDto user) {

        if(user.getName() == null || user.getName().isBlank()
          ||  user.getLoginId() == null || user.getLoginId().isBlank()
          ||  user.getPassword() == null || user.getPassword().isBlank()) {
            return "すべての項目を入力してください";
        }

        String hashedPassword = hashPassword(user.getPassword());
        
        UserEntity newUser = new UserEntity(
            user.getName(),
            user.getLoginId(),
            hashedPassword
        );
        
        userRepository.save(newUser);
        return "ユーザー情報を受け取りました";
    }

    private String hashPassword(String password) {
        try {
            // Generate a random salt
            byte[] salt = new byte[16];
            new SecureRandom().nextBytes(salt);          

            // Hash the password with the salt using PBKDF2
            PBEKeySpec spec = new PBEKeySpec(
                password.toCharArray(),
                salt,
                600000,
                256
            );
            
        try {
            byte[] hash = SecretKeyFactory
            .getInstance("PBKDF2WithHmacSHA256")
            .generateSecret(spec)
            .getEncoded();

            // Return the combined salt and hash as a Base64 encoded string
            return Base64.getEncoder().encodeToString(salt)
                + ":"
                + Base64.getEncoder().encodeToString(hash);
        } finally {
            spec.clearPassword();
        }
    } catch (Exception e) {
            throw new IllegalStateException(
                "パスワードの処理に失敗しました", e
            );
        }
    }
    
    @PostMapping("/login")
    public String login(@RequestBody LoginDto login) {

        UserEntity user = userRepository.findByLoginId(login.getLoginId());

        if (user == null || login.getPassword() == null) {
            return "ログイン失敗";
        }

        String[] parts = user.getPassword().split(":");

        if (parts.length != 2) {
            return "ログイン失敗";
        }

        try {
            byte[] salt = Base64.getDecoder().decode(parts[0]);
            byte[] savedHash = Base64.getDecoder().decode(parts[1]);

            PBEKeySpec spec = new PBEKeySpec(
                login.getPassword().toCharArray(),
                salt,
                600000,
                256
            );

            try {
                byte[] inputHash = SecretKeyFactory
                    .getInstance("PBKDF2WithHmacSHA256")
                    .generateSecret(spec)
                    .getEncoded();

                if (MessageDigest.isEqual(savedHash, inputHash)) {
                    return "ログイン成功";
                }

                return "ログイン失敗";
            } finally {
                spec.clearPassword();
            }

        } catch (Exception e) {
            return "ログイン失敗";
        }
    }
}
