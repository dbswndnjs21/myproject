package com.example.demo.controller;

import com.example.demo.dto.Login;
import com.example.demo.dto.Member;
import com.example.demo.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;

@Controller
public class LoginController {

    @Autowired
    private MemberService memberService;

    @GetMapping("/member/login")
    public String loginForm() {
        return "member/login";
    }

    @PostMapping("/member/login")
    public String login(Login login, HttpServletRequest request, Model model) {
        HashMap<String, String> map = new HashMap<>();
        map.put("id", login.getId());
        map.put("pwd", login.getPwd());
        Member member = memberService.isMember(map);
        if (member == null) { // 회원이 아닌경우
            return "redirect:/member/login";
        } else {
            HttpSession session = request.getSession();//세션 객체에 얻어오기
            session.setAttribute("id", member.getId()); // 세션에 아이디 저장하기
            return "redirect:/";
        }
    }
}
