package com.example.demo.repository;

import com.example.demo.entity.Member;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

@SpringBootTest
@Transactional
@Rollback(value = false) // 롤백하지마라
public class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;

    @Test
    void insert() {
        Member member = new Member("hello","1234",10,"123@");
        memberRepository.save(member);
    }

    @Test
    void select(){
        Member member = memberRepository.select("hello");
        System.out.println(member);
    }

    @Test
    void update(){
        Member m = memberRepository.update(new Member("hello", "123400", 20, "123@tee"));
        System.out.println("변경후 : " + m);
    }

    @Test
    void delete() {
        memberRepository.delete("hello");
    }

    @Test
    void count() {
        Long count = memberRepository.count1();
        System.out.println(count);
    }

    @Test
    void selectList(){
        Member member = memberRepository.selectList();
        System.out.println(member);
    }

    @Test
    void count2() {
        int count = memberRepository.count2();
        System.out.println(count);
    }
}

