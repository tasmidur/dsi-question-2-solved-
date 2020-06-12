package com.example.demo;

import com.example.demo.dao.Userdao;

import com.example.demo.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class FirstApp {

    public static void main(String[] args) {
        SpringApplication.run(FirstApp.class, args);

    }

}
