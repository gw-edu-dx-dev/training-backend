package com.example.training_backend.controller;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//挨拶 API コントローラー 
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5173")
public class HelloController {
    
    //名前に応じて挨拶メッセージを返す
    @GetMapping("/hello")
    public String sayHello(@RequestParam(value = "name", defaultValue = "Guest") String name) {
        return "こんにちは" + name + "さん";
    }    
}
