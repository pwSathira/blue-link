package com.polywertz.bluelink.controller;

import com.polywertz.bluelink.db.User;
import com.polywertz.bluelink.db.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User createUser(String name, String passwordString, long id) {
        User newUser = new User();
        newUser.setName(name);
        newUser.setPassword(passwordString);
        newUser.setId(id);
        return userRepository.save(newUser);
    }
}
