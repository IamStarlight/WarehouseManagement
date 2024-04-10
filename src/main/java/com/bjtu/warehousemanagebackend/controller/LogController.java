package com.bjtu.warehousemanagebackend.controller;

import com.bjtu.warehousemanagebackend.entity.User;
import com.bjtu.warehousemanagebackend.utils.Result;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.bjtu.warehousemanagebackend.service.impl.UserServiceImpl;

@RestController
public class LogController {

    @Autowired
    private UserServiceImpl userService;

    //登录用户
    @PostMapping("/login")
    public ResponseEntity<Result> login(@RequestBody @Valid User user){
        return new ResponseEntity<>(Result.success(userService.login(user)), HttpStatus.OK);
    }

    //登出用户
    @DeleteMapping("/logout")
    public ResponseEntity<Result> logout(){
        userService.logout();
        return new ResponseEntity<>(Result.success(), HttpStatus.OK);
    }
}