package com.sanjusabu.springbootproject.controller;

import com.sanjusabu.springbootproject.entity.MyUser;
import com.sanjusabu.springbootproject.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class MyUserController {

    final private UserService userService;

    public MyUserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public MyUser getAllUsers() {
        return userService.getAllUsers();
    }
}
