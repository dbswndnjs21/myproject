package com.jhta.controller;

import com.jhta.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import test.vo.BoardVo;

@Controller
public class InsertController {
    @Autowired
    BoardService boardService;

    @GetMapping("/board/insert")
    public String insertForm() {
        return "board/insert";
    }

    @PostMapping("/board/insert")
    public ModelAndView insert(BoardVo vo) {
        String code = "success";
        try {
            boardService.insert(vo);
        } catch (Exception e) {
            e.printStackTrace();
            code="error";
        }
        ModelAndView mv = new ModelAndView("board/result");
        mv.addObject("code", code);
        return mv;
    }
    }

