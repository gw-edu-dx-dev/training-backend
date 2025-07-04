package com.example.training_backend.dto;

import lombok.Data;

@Data
public class UserRequest {
    private Long id;
    private String name;
    private String email;
}