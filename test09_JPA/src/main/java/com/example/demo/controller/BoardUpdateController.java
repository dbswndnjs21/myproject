package com.example.demo.controller;

import com.example.demo.dto.BoardDto;
import com.example.demo.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BoardUpdateController {

    @Autowired
    private BoardService boardService;

    @GetMapping("/board/update")
    public String updateForm(@RequestParam("num") Long num, Model model){
        BoardDto dto = boardService.findById(num);
        model.addAttribute("board", dto);
        return "/board/update";
    }

    @PostMapping("/board/update")
    public String update(BoardDto dto){
        BoardDto update = boardService.update(dto);
        return "redirect:/board/list";
    }
}
