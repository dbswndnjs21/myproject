package com.example.demo.repository;

import com.example.demo.entity.Member;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Rollback;

import java.util.List;

@SpringBootTest
@Transactional
@Rollback(value = false)
public class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Test
    void insert() {
        memberRepository.save(new Member("aa", "aa", "AA@doe.com", 10, null));
        memberRepository.save(new Member("bb", "bb", "BB@doe.com", 11, null));
        memberRepository.save(new Member("cc", "cc", "CC@doe.com", 12, null));
        memberRepository.save(new Member("dd", "dd", "DD@doe.com", 13, null));
        memberRepository.save(new Member("ee", "ee", "EE@doe.com", 14, null));
        memberRepository.save(new Member("ff", "ff", "FF@doe.com", 15, null));
        memberRepository.save(new Member("gg", "gg", "GG@doe.com", 16, null));
        memberRepository.save(new Member("hh", "hh", "HH@doe.com", 17, null));
    }

    @Test
    void pageTest(){
        // 0 페이지서 부터 3개 데이터 꺼내오기 -> 시작페이지가 0부터임 주의
        PageRequest pageRequest = PageRequest.of(0, 3, Sort.by("id").descending()); // of(페이지넘버, 페이지사이즈, sort에 대한 정보)
        Page<Member> page = memberRepository.findAll(pageRequest);// 리턴 타입이 page<Member>
        System.out.println("전체 페이지 수 : " + page.getTotalPages());
        System.out.println("현재 페이지 : " + page.getNumber());
//        List<Member> list = page.getContent(); // 이렇게 List로 받을수도있음
        page.forEach(e->{
            System.out.println(e);
        });
    }
    
    @Test
    void pageTest2(){
        // 0페이지에서 10살이상 데이터를 5개 꺼내오기
        List<Member> list = memberRepository.findList(10, 5, 0);
        list.forEach(m->{
            System.out.println(m);
        });
    }

    @Test
    void update(){
        // bb인사람 10살 올리기
        int update = memberRepository.update("bb");
        System.out.println(update);
    }

}
