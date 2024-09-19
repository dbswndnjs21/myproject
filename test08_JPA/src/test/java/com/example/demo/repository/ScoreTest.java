package com.example.demo.repository;

import com.example.demo.entity.Score;
import com.example.demo.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@SpringBootTest
@Transactional
@Rollback(value = false)
public class ScoreTest {

    @Autowired
    private ScoreRepository scoreRepository;
    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void save() {
        Optional<Student> byId = studentRepository.findById(2);
        Student student = byId.get();
        scoreRepository.save(new Score(0L, student, " ", 21, " "));

    }
}
