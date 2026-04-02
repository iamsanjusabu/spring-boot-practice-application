package com.sanjusabu.springboot.controller;

import com.sanjusabu.springboot.dto.UserDTO;
import com.sanjusabu.springboot.service.InMemoryUserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/in-memory/users")
public class HardCodedUserController {

    final private InMemoryUserService inMemoryUserService;

    public HardCodedUserController(InMemoryUserService inMemoryUserService) {
        this.inMemoryUserService = inMemoryUserService;
    }

    @GetMapping
    public List<UserDTO> getAllUsers() {
        return inMemoryUserService.getAllUsers();
    }

    @GetMapping("{id}")
    public UserDTO getUserById(@PathVariable("id") Long id) {
        return inMemoryUserService.getUserById(id);
    }
}
