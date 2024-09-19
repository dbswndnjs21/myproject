package com.example.demo.controller;

import com.example.demo.dto.MemberDto;
import com.example.demo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UpdateController {

    @Autowired
    private MemberService memberService;

    @GetMapping("/member/update")
    private String updateFrom(@RequestParam("id")String id, Model model) {
        MemberDto memberDto = memberService.selectOne(id);
        model.addAttribute("member", memberDto);
        return "member/update";
    }

    @PostMapping("/member/update")
    private String update(@ModelAttribute("member") MemberDto dto) {
        MemberDto update = memberService.update(dto);
        return "redirect:/member/list";
    }
}
