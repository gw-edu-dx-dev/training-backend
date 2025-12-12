package com.example.training_backend.service;

import org.springframework.stereotype.Service;

import com.example.training_backend.dto.LoginResponse;
import com.example.training_backend.entity.User;
import com.example.training_backend.repository.UserRepository;

@Service
public class LoginService {
    private final UserRepository userRepository;

    public LoginService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public LoginResponse login(Long id,String password){
        // Optionalの中にUsergaあればUserが返る。なければnullが返る
        User user = userRepository.findById(id).orElse(null);

        // nullの場合
        if(user == null){
            return new LoginResponse(false, "ログインIDまたはパスワードが違います");
        }

        // 入力内容に誤りがあった場合
        if(!user.getPassword().equals(password)){
            return new LoginResponse(false, "ログインIDまたはパスワードが違います");
        } 

        // ログイン成功時
        return new LoginResponse(true,"ログインに成功しました(ようこそ "+ user.getName() + "さん)");

    }
}
