package com.example.demo.controller;

import com.example.demo.dto.BoardDto;
import com.example.demo.entity.Board;
import com.example.demo.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class InsertController {
    @Autowired
    private BoardService boardService;

    @GetMapping("/board/insert")
    public String insertForm() {
        return "board/insert";
    }

    @PostMapping("/board/insert")
   public String insert(@ModelAttribute BoardDto boardDto){
        BoardDto insert = boardService.insert(boardDto);
        return "board/result";
    }
}
