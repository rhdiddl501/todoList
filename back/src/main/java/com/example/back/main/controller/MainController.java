package com.example.back.main.controller;

import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.*;

@RestController
@RequestMapping(value = "/api/v1/main")
public class MainController {


    @PostMapping(value = "/get-main")
    public String getMain(@RequestBody String userId) {
        System.out.println("userID: " + userId);

        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306", "testUser", "test123$");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("show databases");
            while (rs.next()) {
                System.out.println(rs.getString(1));
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }


        return userId + "을 받았습니다.";
    }

}
