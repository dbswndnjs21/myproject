package com.example.demo.repository;

import com.example.demo.entity.Board;
import com.example.demo.entity.Member;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

@SpringBootTest
@Transactional
@Rollback(value = false)
public class BoardRepositoryTest {

    @Autowired
    private BoardRepository boardRepository;
    @Autowired
    private MemberRepository memberRepository;

    @Test
    public void insert(){
        Optional<Member> byId = memberRepository.findById("aa");

        if (byId.isPresent()) {
            Member member = byId.get();
            boardRepository.save(new Board(0L, member, "제목2", "내용2", null));
            boardRepository.save(new Board(0L, member, "제목3", "내용3", null));
            boardRepository.save(new Board(0L, member, "제목4", "내용4", null));
            boardRepository.save(new Board(0L, member, "제목5", "내용5", null));
            boardRepository.save(new Board(0L, member, "제목6", "내용6", null));
            boardRepository.save(new Board(0L, member, "제목7", "내용7", null));
            boardRepository.save(new Board(0L, member, "제목8", "내용8", null));
            boardRepository.save(new Board(0L, member, "제목9", "내용9", null));
            boardRepository.save(new Board(0L, member, "제목10", "내용10", null));
            boardRepository.save(new Board(0L, member, "제목11", "내용11", null));
        }
    }
    
    @Test
    public void list() {
        // 레포지토리에서 pageable를 선언 안해도 가능
        PageRequest pageRequest = PageRequest.of(1, 5);
        Page<Board> page = boardRepository.findAll(pageRequest);
        page.forEach(p->{
            System.out.println(p);
        });
    }
}
