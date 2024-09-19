package com.example.demo.repository;

import com.example.demo.entity.MyUser;
import jakarta.transaction.Transactional;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.Optional;

@SpringBootTest
@Transactional
@Rollback(value = false)
@Slf4j // 로그찍기
public class MyUserTest {

    @Autowired
    MyUserRepository myUserRepository;

    @Test
    public void test() {
        MyUser myUser = myUserRepository.save(new MyUser("user4", "1534", "sdf@d", null,null ));
        log.info("user=> {}",myUser ); // 로그 레벨을 info로 준것 -> 쓸려면 설정에서 logging.level.root=info 해주기
    }

    @Test
    public void update(){
        MyUser user = new MyUser("user2", "111", "modi@d", null,null );
        Optional<MyUser> user2 = myUserRepository.findById("user2");
        MyUser myUser = user2.get();
        myUser.setPassword(user.getPassword());
        myUser.setEmail(user.getEmail());
    }

    @Test
    public void delete(){
        myUserRepository.deleteById("user2");
    }

    @Test
    public void selectList() {
        List<MyUser> list = myUserRepository.findAll();
        list.forEach(m-> System.out.println(m));
    }
}
