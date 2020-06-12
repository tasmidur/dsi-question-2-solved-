package com.example.demo.controller;

import com.example.demo.dao.Userdao;
import com.example.demo.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    public Userdao userdao;

    @GetMapping("/")
    public String getSignInIndex(){
        return "loginform";
    }

    @PostMapping("/")
    public  @ResponseBody
    int singIn(@RequestParam String username,@RequestParam String password){
        List<Users> usersList=userdao.findByUserName(username,password);
        if (!usersList.isEmpty()){
            return 1;
        }
        return 0;
    }



    @GetMapping("/success")
    public String success(){
        return "success";
    }

    @GetMapping("/error")
    public String error(){
        return "error";
    }

    @GetMapping("/not-success")
    public String notSuccess(){
        return "not-success";
    }



}
