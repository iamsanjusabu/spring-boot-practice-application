package com.sanjusabu.springbootproject.components;

import com.sanjusabu.springbootproject.entity.MyUser;
import com.sanjusabu.springbootproject.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DataSeeder implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public DataSeeder(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void run(String... args) {
        if (userRepository.findByUsername("admin").isEmpty()) {
            MyUser user = new MyUser();

            user.setUsername("admin");
            user.setPassword(passwordEncoder.encode("sanju1234"));
            user.setAge(19);
            user.setGender('M');
            user.setEmail("sanjusabu@icloud.com");

            userRepository.save(user);

            log.info("Seeded admin user");
        }
    }
}
