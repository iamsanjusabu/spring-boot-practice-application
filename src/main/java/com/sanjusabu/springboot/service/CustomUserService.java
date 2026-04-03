package com.sanjusabu.springboot.service;

import com.sanjusabu.springboot.model.MyUser;
import com.sanjusabu.springboot.repo.UserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomUserService implements UserDetailsService {

    final private UserRepository userRepo;

    public CustomUserService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        MyUser user = userRepo.findByName(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return new User(user.getName(), user.getPassword(), List.of());
    }
}
