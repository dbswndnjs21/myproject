package com.example.demo.repository;

import com.example.demo.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@SpringBootTest
@Transactional
@Rollback(value = false)
public class StudentTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void save() {
        Student student = new Student(0, "이유현", "영어", 80);
        Student student1 = new Student(0, "윤주원", "과학", 90);
        studentRepository.save(student);
        studentRepository.save(student1);
    }

    @Test
    void update() {
        Optional<Student> byId = studentRepository.findById(1);
        Student student = byId.get();
        student.setName("이유현");
        System.out.println("결과 : " + student);
    }

    @Test
    void select(){
        Optional<Student> byId = studentRepository.findById(1);
        Student student = byId.get();
        System.out.println("1번 학생 : " + student);
    }

    @Test
    void selectAll() {
        List<Student> students = studentRepository.findAll();
        for (Student student : students) {
            System.out.println(student);
        }
    }

    @Test
    void delete() {
        studentRepository.deleteById(1);
    }
}
