package com.example.demo.service;

import com.example.demo.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
@Commit
public class UserServiceTest {

    @Autowired
    UserService userService;

    @Test
    void save() {
        userService.save(new User(0L, "user1", "1234", "MEMBER"));
    }

    @Test
    void idmember(){
        boolean result = userService.isMember("user1", "123114");
        System.out.println("result = " + result);
    }

}
