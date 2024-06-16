package com.example.back.main.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.*;

@Slf4j
@RestController
@RequestMapping(value = "/api/v1/main")
public class MainController {

    @Value("${spring.datasource.url}")
    private String dbUrl;
    @Value("${spring.datasource.username}")
    private String dbUser;
    @Value("${spring.datasource.password}")
    private String dbPwd;
    @PostMapping(value = "/get-main")
    public String getMain(@RequestBody String userId) {
        System.out.println("userID: " + userId);

        try {
            Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPwd);
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
