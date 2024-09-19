package com.example.demo.repository;

import com.example.demo.dto.BoardDto;
import com.example.demo.entity.Board;
import com.example.demo.entity.MyUser;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.Optional;

@SpringBootTest
@Transactional
@Rollback(value = false)
public class BoardTest {

    @Autowired
    private BoardRepository boardRepository;
    @Autowired
    private MyUserRepository myUserRepository;

    @Test
    void save() {
        Optional<MyUser> user1 = myUserRepository.findById("user1");
        // user1에는 user1 Id를 가지고 검색한 객체가 들어있고
        if (!user1.isEmpty()) {
            MyUser user = user1.get(); // Optional에서 꺼내주고
            System.out.println(" 어딨어 " + user);
            // 여기에 user를 넣으면 자동으로 user객체에서 username 만 빼서 저장함
            // FK로 지정했기 때문
            boardRepository.save(new Board(0L, user, "te234511st", "fesfsfs23412341234ef", null));
        }
    }

    @Test
    void listAll() {
        List<Board> list = boardRepository.findAll();
        list.forEach(m->{
            System.out.println("글번호 : " + m.getNum());
            System.out.println("작성자 : " + m.getUser().getUsername());
            System.out.println("제목 : " + m.getTitle());
            System.out.println("내용 : " + m.getContent());
            System.out.println("작성일 : " + m.getRegdate());
            System.out.println("이건 내가 궁금 : " + m.getUser());
            System.out.println();
        });
    }

    @Test
    void list1() {
        List<Board> list = boardRepository.list1();
        list.forEach(m->{
            System.out.println("-----시작------");
            System.out.println("글번호 : " + m.getNum());
            System.out.println("작성자 : " + m.getUser().getUsername());
            System.out.println("제목 : " + m.getTitle());
            System.out.println("내용 : " + m.getContent());
            System.out.println("작성일 : " + m.getRegdate());
            System.out.println();
        });
    }

    @Test
    void list2() {
        List<Board> list = boardRepository.list2("user1");
        list.forEach(m->{
            System.out.println("-----시작------");
            System.out.println("글번호 : " + m.getNum());
            System.out.println("작성자 : " + m.getUser().getUsername());
            System.out.println("제목 : " + m.getTitle());
            System.out.println("내용 : " + m.getContent());
            System.out.println("작성일 : " + m.getRegdate());
            System.out.println();
        });
    }

    @Test
    void list3() {
        List<BoardDto> list = boardRepository.list3();
        list.forEach(m->{
            System.out.println(m);
        });
    }


}
