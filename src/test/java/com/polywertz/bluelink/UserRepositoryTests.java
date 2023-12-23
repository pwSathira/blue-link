//package com.polywertz.bluelink;
//
//import com.polywertz.bluelink.db.User;
//import com.polywertz.bluelink.db.UserRepository;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//@SpringBootTest
//public class UserRepositoryTests {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Test
//    public void testCreateReadDelete() {
//        User user = new User();
//        user.setName("Test User");
//
//        userRepository.save(user); // Create
//
//        Iterable<User> users = userRepository.findAll();
//        assertThat(users).extracting(User::getName).contains("Test User");
//
//        userRepository.deleteAll(); // Cleanup
//    }
//}
