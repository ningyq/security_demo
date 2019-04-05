package com.ningyq.security_demo.controller;

import com.ningyq.security_demo.bean.User;
import com.ningyq.security_demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ning")
public class AdminController {

    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public List<User> getAllUser() {
        return userService.getAllUser();
    }
}
