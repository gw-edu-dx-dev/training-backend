package com.example.training_backend.service;

import com.example.training_backend.dto.UserRequest;
import com.example.training_backend.dto.UserResponse;
import com.example.training_backend.entity.Users;
import com.example.training_backend.repository.UsersRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UsersRepository usersRepository;

    /**
     * 全ユーザー情報を取得する。
     *
     * @return 全ユーザー情報のリスト
     * @throws DataAccessException DB関連エラーが発生した場合
     */
    public List<UserResponse> getAllUsers() {
        try {
            return usersRepository.findAll().stream()
            .map(this::toUserResponse)
            .collect(Collectors.toList());
        } catch (DataAccessException e) {
            System.err.println("DB接続エラー: " + e.getMessage());
            throw new RuntimeException("ユーザー一覧取得に失敗しました。", e);
        }
    }

    /**
     * EntityをDTOに変換する。
     *
     * @param users Entity
     * @return レスポンス用DTO
     */
    private UserResponse toUserResponse(Users users) {
    return UserResponse.builder()
        .id(users.getId())
        .name(users.getName())
        .email(users.getEmail())
        .build();
    }

    /**
     * 新規ユーザーを登録する。
     *
     * @param userRequest ユーザー登録リクエスト
     * @throws DataAccessException すべてのDB関連エラーが発生した場合
     */
    public void registerUser(UserRequest userRequest) {
        Users users = Users.builder()
            .name(userRequest.getName())
            .email(userRequest.getEmail())
            .build();
        try{
            usersRepository.save(users);
            System.out.println("ユーザー登録が完了しました。");
            System.out.println("NAME: " + userRequest.getName());
            System.out.println("E-MAIL: " + userRequest.getEmail());
        } catch (DataAccessException e) {
            System.err.println("DB接続エラー: " + e.getMessage());
            throw new RuntimeException("DB登録処理に失敗しました。", e);
        }
    };
}