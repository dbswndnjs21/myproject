package com.example.demo;

import com.example.demo.dto.Member;
import com.example.demo.service.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;

@SpringBootTest
// 제이유닛을 이용해서 검증 해줌
public class MemberServiceTest {
    // 테스트할 클래스 주입
    @Autowired
    private MemberService memberService;
    
//    @Test
//    // void로 해야함
//     void insert() {
//        int insert = memberService.insert(new Member("hello", "1234", "1234@ma", 10, null));
////        System.out.println("회원 등록 -> " + insert);
//    }

    @Test
    void list() {
        HashMap<String,Object> map = new HashMap<>();
        map.put("startRow", 1);
        map.put("endRow", 5);
        List<Member> list = memberService.list(map);
        list.forEach(m-> {
            System.out.println(m);
        });
    }

//    @Test
//    void count(){
//        int n = memberService.count();
////        assertThat().isEq
//    }
}
