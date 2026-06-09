package com.example.training_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.training_backend.repository.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}