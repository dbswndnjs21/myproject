package com.example.demo.repository;

import com.example.demo.entity.Member;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@Transactional
@Rollback(value = false)
public class MemberRepositoryJPATest {

    @Autowired
    MemberRepositoryJPA mr;

    @Test
    void insert() {
        Member member = new Member("abc","1234",10,"123@");
        Member m1 = mr.save(member);
        System.out.println(m1);

    }

    @Test
    void select() {
        Optional<Member> m = mr.findById("abc"); // 리턴이 Optional 임
        if (!m.isEmpty()) {
            Member member = m.get();
            System.out.println(member);
        }
        // Optional
        // 자바 8 에 추가된 기능
        // Null 예외 나지 않게 하기 위해서 자주 씀
    }

    @Test
    void selectAll(){
        List<Member> list = mr.findAll();
        list.forEach(m->System.out.println(m));
    }

    @Test
    void delete() {
        mr.deleteById("abc");
    }
    
    @Test
    void update() {
        // 수정은 따로 메소드가 없음
        Member m = new Member("hello","2345",100,"123@erg");
        Member member = mr.findById("hello").get();
        member.setAge(m.getAge());
        member.setEmail(m.getEmail());
        member.setPassword(m.getPassword());
        System.out.println("완려");
    }

    @Test
    void select1() {
        Member m = mr.select("hello");
    }

    @Test
    void select2() {
        mr.save(new Member("fff","sdgvb",10,"12111@"));
        mr.save(new Member("ddd","sdxcvg",20,"23@"));
        mr.save(new Member("ccc","sdweg",30,"33@"));

        List<String> list = new ArrayList<>();
        list.add("hello");
        list.add("fff");
        list.add("aaa");

        List<Member> mlist = mr.findMember(list);
        mlist.forEach(m->System.out.println(m));

    }

    @Test
    void age() {
        List<Member> memberByAge = mr.findMemberByAge(15);
        memberByAge.forEach(m->System.out.println(m));
    }

    @Test
    void idPassword(){
        Member memberByPassword = mr.findMemberByPassword("ccc", "sdweg");
        System.out.println(memberByPassword);
    }


}
