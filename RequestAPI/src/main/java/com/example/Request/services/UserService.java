package com.example.Request.services;

import com.example.Request.dao.UserRepository;
import com.example.Request.models.Users;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

public class UserService {

    public UserService() {
    }

    private UserRepository userRepository;


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<Users> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public Optional<Users> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public void setRepository(UserRepository repository) {
    }
}