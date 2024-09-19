package com.example.demo.controller;

import com.example.demo.dto.MemberDto;
import com.example.demo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class listController {

    @Autowired
    private MemberService memberService;

    @GetMapping("/member/list")
    public String list(Model model){
        List<MemberDto> list = memberService.list();
        model.addAttribute("list", list);
        return "member/list";
    }
}
