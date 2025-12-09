package com.example.training_backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.training_backend.Entity.User;
import com.example.training_backend.dto.CreateUserRequest;
import com.example.training_backend.dto.UserDto;
import com.example.training_backend.reository.UserRepository;

@Service
public class UserService {
    
    private final UserRepository userRepository;
 
    // コンストラクタインジェクション
    // クラスが依存しているオブジェクトをコンストラクタを通して注入する方法
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    // ユーザー一覧取得
    public List<UserDto> getAllUsers(){
        List<User> users = userRepository.findAll();
        
        // EntityをDTOに変換
        return users.stream()
            .map(user -> new UserDto(user.getId(), user.getName(), user.getEmail()))
            .toList();
    }

    // ユーザー新規登録
    public UserDto createUser(CreateUserRequest request){
        // DtoをEntityに変換
        User user = new User(request.getName(), request.getEmail());
        User saved = userRepository.save(user);

        // 保存されたEntityからDTOを作成して返す
        return new UserDto(saved.getId(), saved.getName(), saved.getEmail());
    }
}
