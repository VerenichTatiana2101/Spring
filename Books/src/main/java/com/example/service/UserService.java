package com.example.service;

import com.example.model.User;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        // для проверки
        userRepository.save(new User(null, "Tatiana", "verenik91@gmail.com"));
        userRepository.save(new User(null, "Anna", "vera91@gmail.com"));
        userRepository.save(new User(null, "Inna", "viktoria91@gmail.com"));
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id);
    }
}
