package com.example.demo.repository;

import com.example.demo.dto.BoardDto;
import com.example.demo.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {


    @Query("select b from Board b join b.user u ")
    List<Board> list1();

    @Query("select b from Board b join b.user u where u.username = :username")
    List<Board> list2(@Param("username") String username);

    @Query("select new com.example.demo.dto.BoardDto(b.num, u.username, b.title, b.content) from Board b join b.user u")
    List<BoardDto> list3();
}

