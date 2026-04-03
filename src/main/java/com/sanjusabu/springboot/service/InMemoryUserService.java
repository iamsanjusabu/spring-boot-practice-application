package com.sanjusabu.springboot.service;

import com.sanjusabu.springboot.dto.UserDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InMemoryUserService {
    List<UserDTO> users = new ArrayList<>(List.of(
       new UserDTO(1L, "Sanju", 19, 'M', "sanjusabu@icloud.com"),
        new UserDTO(2L, "Sahil", 27, 'M', "shailasabu@example.com"),
        new UserDTO(3L, "Shaila", 49, 'F', "sahilsabu@example.com"),
        new UserDTO(4L, "Sabu", 52, 'M', "sabu@example.com"),
        new UserDTO(5L, "Ethan", 0, 'M', "ethan@example.com")
    ));


    public List<UserDTO> getAllUsers()  {
        return users;
    }

    public UserDTO getUserById(Long id) {
        for (UserDTO user: users) {
            if (user.getId().equals(id)) {
                return user;
            }
        }

        return null;
    }
}
