package com.example.training_backend.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserRequest {
    private String name;
    private String email;
}