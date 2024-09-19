package com.example.demo.controller;

import com.example.demo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DeleteController {

    @Autowired
    private MemberService memberService;

    @GetMapping("/member/delete")
    public String deleteMember(@RequestParam("id") String id, Model model) {
        int delete = memberService.delete(id);
        if (delete == 1) {
            return "redirect:/member/list";
        } else {
            model.addAttribute("msg", "삭제 실패");
            return "member/result";
        }
    }
}
