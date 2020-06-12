package com.example.demo.dao;

import com.example.demo.controller.UserController;

import com.example.demo.entity.Users;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface Userdao extends CrudRepository<Users,Long> {
    @Query("SELECT e from Users e where e.userName =:name and e.password=:password ")       // using @query
    List<Users> findByUserName(@Param("name") String name,@Param("password")String password);
}
