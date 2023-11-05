package com.example.firstspringproject.services;

import com.example.firstspringproject.models.User;
import com.example.firstspringproject.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Reader;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public void registerUser(User user) {

        User userToFind = userRepository.findByUsername(user.getUsername());

        if (userToFind == null) {
            userRepository.save(user);
        }
    }

    @Override
    public User getUser(User user) {
        return userRepository.findByUsername(user.getUsername());
    }

}
