package com.polywertz.bluelink.controller;

import com.polywertz.bluelink.db.User;
import com.polywertz.bluelink.db.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    private User currentUser;

    public User createUser(String name, String passwordString) {
        User newUser = new User();
        newUser.setName(name);
        newUser.setPassword(passwordString);
        return userRepository.save(newUser);
    }
    public boolean checkUser(String name, String passwordString) {
        User user = findUser(name);
        if (user == null) {
            return false;
        }
        else {
            return user.getPassword().equals(passwordString);
        }
    }
    public User findUser(String name) {
        return userRepository.findByName(name);
    }
    public void setCurrentUser(User user) {
        currentUser = user;
    }
    public User getCurrentUser() {
        return currentUser;
    }
}
