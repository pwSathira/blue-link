//package com.polywertz.bluelink.controller;
//
//import com.polywertz.bluelink.db.User;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class UserController {
//
//    private final UserService userService;
//
//    @Autowired
//    public UserController(UserService userService) {
//        this.userService = userService;
//    }
//
//    @GetMapping("/createUser")
//    public String createAUser() {
//        User user = userService.createUser("Alice", passwordString);
//        return "Created user with ID: " + user.getId();
//    }
//}
