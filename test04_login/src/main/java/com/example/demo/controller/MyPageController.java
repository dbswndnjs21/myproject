package com.example.demo.controller;

import com.example.demo.dto.Member;
import com.example.demo.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyPageController {
    @Autowired
    private MemberService memberService;

    @GetMapping("/member/mypage")
    public String mypage(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        String id = (String) session.getAttribute("id");
        if (id == null) {
            return "redirect:/login";
        } else {
            Member member = memberService.selectOne(id);
            model.addAttribute("member", member);
            return "member/mypage";
        }
    }
}
