package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BoardController {
    @GetMapping("/member/board")
    public String board(Model model) {
        List<String> list = new ArrayList<>();
        list.add("게시글1");
        list.add("게시글2");
        list.add("게시글3");
        model.addAttribute("list", list);
        return "member/board";
    }
}
