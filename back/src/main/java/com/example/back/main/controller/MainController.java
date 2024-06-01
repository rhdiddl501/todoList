package com.example.back.main.controller;

import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/main")
public class MainController {


    @PostMapping(value = "/get-main")
    public String getMain(@RequestBody String userId) {
        System.out.println("userID: " + userId);
        return userId + "을 받았습니다.";
    }

}
