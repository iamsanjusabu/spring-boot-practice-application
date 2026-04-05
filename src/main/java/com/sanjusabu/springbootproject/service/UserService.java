package com.sanjusabu.springbootproject.service;

import com.sanjusabu.springbootproject.dto.UserRequestDTO;
import com.sanjusabu.springbootproject.dto.UserResponseDTO;
import com.sanjusabu.springbootproject.entity.MyUser;
import com.sanjusabu.springbootproject.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // (GET) to get all users
    public ResponseEntity<List<MyUser>> getAllUsers() {
        List<MyUser> users = userRepository.findAll();

        if (users.isEmpty())
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(users);
    }

    // (GET) get a user by id
    public ResponseEntity<MyUser> getUserById(Long id) {
        return userRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // (POST) to CREATE a user
    public ResponseEntity<UserResponseDTO> createUser(UserRequestDTO userToBeCreated) {
        Optional<MyUser> userFromDB = userRepository.findByEmail(userToBeCreated.getUsername());

        if (userFromDB.isEmpty()) {
            MyUser user = new MyUser();
            user.setUsername(userToBeCreated.getUsername());
            user.setPassword(passwordEncoder.encode(userToBeCreated.getPassword()));
            user.setAge(userToBeCreated.getAge());
            user.setGender(userToBeCreated.getGender());
            user.setEmail(userToBeCreated.getEmail());

            userRepository.save(user);

            UserResponseDTO userToBeReturned = new UserResponseDTO();
            userToBeReturned.setId(userRepository.findByEmail(user.getEmail()).get().getId());
            userToBeReturned.setUsername(user.getUsername());
            userToBeReturned.setAge(user.getAge());
            userToBeReturned.setGender(user.getGender());
            userToBeReturned.setEmail(user.getEmail());

            return ResponseEntity.ok(userToBeReturned);
        }

        return ResponseEntity.status(HttpStatus.CONFLICT).build();
    }

    // (PUT) update user by id
    public ResponseEntity<String> updateUserById(Long id, UserRequestDTO userToBeUpdated) {
        if (userRepository.findById(id).isEmpty())
            return ResponseEntity.notFound().build();

        int created = userRepository.updateUser(
                id,
                userToBeUpdated.getUsername(),
                userToBeUpdated.getPassword(),
                userToBeUpdated.getAge(),
                userToBeUpdated.getGender(),
                userToBeUpdated.getEmail()
        );

        if (created == 1)
            return ResponseEntity.ok("User updated");
        return ResponseEntity.status(404).build();
    }

    // (DELETE) delete user by id
    public ResponseEntity<Void> deleteUserById(Long id) {
        if (userRepository.findById(id).isPresent()) {
            userRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }
}
