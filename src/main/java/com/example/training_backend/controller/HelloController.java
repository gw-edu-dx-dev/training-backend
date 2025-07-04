package com.example.training_backend.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.training_backend.dto.NameRequest;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5173/")
public class HelloController {
    @PostMapping("/hello")
    public void receiveName(@RequestBody NameRequest request) {
        System.out.println("こんにちは、" + request.getName() + "さん");
    }
}
