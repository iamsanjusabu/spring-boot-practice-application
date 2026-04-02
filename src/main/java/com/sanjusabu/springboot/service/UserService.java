package com.sanjusabu.springboot.service;

import com.sanjusabu.springboot.dto.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    List<User> users = new ArrayList<>(List.of(
       new User(1L, "Sanju", 19, 'M', "sanjusabu@icloud.com"),
        new User(2L, "Sahil", 27, 'M', "shailasabu@example.com"),
        new User(3L, "Shaila", 49, 'F', "sahilsabu@example.com"),
        new User(4L, "Sabu", 52, 'M', "sabu@example.com"),
        new User(5L, "Ethan", 0, 'M', "ethan@example.com")
    ));


    public List<User> getAllUsers() {
        return users;
    }

    public User getUserById(Long id) {
        for (User user: users) {
            if (user.getId().equals(id)) {
                return user;
            }
        }

        return null;
    }
}
