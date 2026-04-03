package com.sanjusabu.springboot.config;

import com.sanjusabu.springboot.model.MyUser;
import com.sanjusabu.springboot.repo.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder encoder;

    @PostConstruct
    public void init() {
        if (userRepository.findByName("john").isEmpty()) {
            MyUser user = new MyUser();
            user.setName("john");
            user.setPassword(encoder.encode("1234"));
            user.setGender('M');
            user.setEmail("john@example.com");
            user.setAge(19);
            userRepository.save(user);
        }
    }
}