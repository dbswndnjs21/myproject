package com.example.demo.controller;

import com.example.demo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DeleteController {

    @Autowired
    private MemberService memberService;

    @GetMapping("/member/delete")
    public String delete(@RequestParam("id")String id) {
        memberService.delete(id);
        return "redirect:/member/list";
    }

}
