package com.example.demo.controller;

import com.example.demo.dto.MemberDto;
import com.example.demo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class JoinController {

    @Autowired
    private MemberService memberService;

    @GetMapping("/member/join")
    public String joinForm() {
        return "member/join";
    }

    @PostMapping("/member/join")
    public String join(MemberDto dto , Model model) {
        MemberDto join = memberService.join(dto);
        model.addAttribute("member", join);
        model.addAttribute("msg", "가입성공");
        return "member/result";
    }
}
