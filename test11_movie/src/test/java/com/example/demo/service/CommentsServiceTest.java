package com.example.demo.service;

import com.example.demo.dto.CommentsDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
@Rollback(false)
public class CommentsServiceTest {

    @Autowired
    private CommentsService commentsService;

    @Test
    public void save() {
        for (int i = 0; i <= 20; i++) {
            commentsService.save(new CommentsDto(0L,2L,"ㅇㅈㅇ","잼나요"));
        }
    }

    @Test
    public void delete(){
        commentsService.delete(2L);
    }
}
