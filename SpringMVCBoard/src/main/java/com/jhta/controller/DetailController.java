package com.jhta.controller;

import com.jhta.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DetailController {

    @Autowired
    private BoardService boardService;

    @GetMapping("/board/detail")
    public String detail(int num, Model model) {
        model.addAttribute("vo", boardService.detail(num));
        model.addAttribute("prev", boardService.prev(num));
        model.addAttribute("next", boardService.next(num));
        return "board/detail";
    }
}
