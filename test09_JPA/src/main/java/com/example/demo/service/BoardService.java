package com.example.demo.service;

import com.example.demo.dto.BoardDto;
import com.example.demo.dto.PageResultDto;
import com.example.demo.entity.Board;
import com.example.demo.entity.Member;
import com.example.demo.repository.BoardRepository;
import com.example.demo.repository.MemberRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
@Transactional
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;
    @Autowired
    private MemberRepository memberRepository;


    public BoardDto insert(BoardDto boardDto){
        Optional<Member> byId = memberRepository.findById(boardDto.getId());
        Member member = byId.get();
        //Board save = boardRepository.save(new Board(0L, member, boardDto.getTitle(), boardDto.getContent(), null));
        Board entity = boardDto.toEntity(member);
        Board save = boardRepository.save(entity);
        return new BoardDto(save);
    }

    // 글목록
    public PageResultDto list(Pageable pageable){
        Page<Board> page = boardRepository.findAll(pageable);

//        Function<Board,BoardDto> f = new Function<Board, BoardDto>() {
//            @Override
//            public BoardDto apply(Board t) {
//                return new BoardDto(t);
//            }
//        };
//
//        Function<Board, BoardDto> f = (Board t) -> {
//            return new BoardDto(t);
//        };
//
//        Function<Board, BoardDto> f = b-> new BoardDto(b);
//        page.stream().map(f);

//        List<BoardDto> dtoList = page.stream().map(b->new BoardDto(b)).toList();
        List<BoardDto> dtoList = page.stream().map(BoardDto::new).toList();
        PageResultDto pageDto = new PageResultDto(dtoList, page.getNumber(), page.getTotalPages(), 3);
        return pageDto;
    }

    public BoardDto findById(Long id){
        Optional<Board> byId = boardRepository.findById(id);
        return new BoardDto(byId.get());
    }

    public BoardDto update(BoardDto boardDto){
//        System.out.println("boardDTO : " + boardDto);
        Optional<Board> board = boardRepository.findById(boardDto.getNum());
        Board board1 = board.get();
//        System.out.println("보드원 : " + board1);
        board1.setTitle(boardDto.getTitle());
        board1.setContent(boardDto.getContent());
        //@Transactional 가 있기 때문에 아래 문장은 안해줘도됨
//        boardRepository.save(board1);
        return new BoardDto(board1);
    }

    public void delete(BoardDto dto){
        boardRepository.deleteById(dto.getNum());
    }

}
