package com.example.clubheidemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleController {
    @GetMapping("/test/roles/admin")
    public String testRoleAdmin(){
        return "Your are admin";
    }

    @GetMapping("/test/roles/user")
    public String testRoleUser(){
        return "Your are every one an user";
    }
}
