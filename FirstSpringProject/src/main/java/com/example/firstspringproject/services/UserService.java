package com.example.firstspringproject.services;

import com.example.firstspringproject.models.User;

public interface UserService {
    void registerUser(User user);
    User getUser(User user);
}
