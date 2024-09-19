package com.example.demo.controller;

import com.example.demo.dto.Member;
import com.example.demo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class InsertController {
    @Autowired
    private MemberService memberService;

    @GetMapping("/member/insert")
    public String insert() {
        return "member/insert";
    }

    @PostMapping("/member/insert")
    public String insertPost(@ModelAttribute Member member, Model model) {
        int insert = memberService.insert(member);
        if (insert > 0) {
            model.addAttribute("msg", "가입 성공");
        } else {
            model.addAttribute("msg", "가입 실패");
        } 
        return "member/result";
    }
}
