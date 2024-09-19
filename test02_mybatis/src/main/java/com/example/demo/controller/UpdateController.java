package com.example.demo.controller;

import com.example.demo.dto.Member;
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
    public String update(@RequestParam("id") String id, Model model) {
        Member member = memberService.selectOne(id);
        model.addAttribute("member", member);
        return "member/update";
    }

    @PostMapping("/member/update")
    public String update(@ModelAttribute Member member) {
        int update = memberService.update(member);
        if (update == 1) {
            return "redirect:/member/list";
        } else {
            return "member/result";
        }

    }
}
