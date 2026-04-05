package com.sanjusabu.springbootproject.controller;

import com.sanjusabu.springbootproject.dto.UserRequestDTO;
import com.sanjusabu.springbootproject.dto.UserResponseDTO;
import com.sanjusabu.springbootproject.entity.MyUser;
import com.sanjusabu.springbootproject.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class MyUserController {

    final private UserService userService;

    public MyUserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<MyUser>> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("{id}")
    public ResponseEntity<MyUser> getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PostMapping
    public ResponseEntity<UserResponseDTO> createUser(@RequestBody UserRequestDTO user) {
        return userService.createUser(user);
    }

    @PutMapping("update-user/{id}")
    public ResponseEntity<String> updateUserById(@PathVariable Long id, UserRequestDTO user) {
        return userService.updateUserById(id, user);
    }

    @DeleteMapping("delete-user/{id}")
    public ResponseEntity<Void> deleteUserById(@PathVariable Long id) {
        return userService.deleteUserById(id);
    }
}
