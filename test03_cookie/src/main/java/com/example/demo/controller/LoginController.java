package com.example.demo.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @GetMapping("/member/login")
    public String loginForm() {
        return "member/login";
    }

    @PostMapping("/member/login")
    public String login(@RequestParam("id") String id,@RequestParam("pwd") String pwd, HttpServletResponse response) {
        if (id.equals("hello") && pwd.equals("1234")) {
            Cookie cookie = new Cookie("id",id);
            cookie.setMaxAge(60*3); // 쿠키 유지 시간 3분( 초단위) -> 브라우저를 닫아도 3분은 유지 됨
            // 유지 시간을 설정 안해주면 -> 웹브라우저 닫을때 까지
            response.addCookie(cookie);
            return "redirect:/";
        }
        return "member/login";
    }

    @GetMapping("/member/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Cookie cookie = new Cookie("id", null);
        cookie.setMaxAge(0); // 세션 유지 시간을 0으로 없애고
        response.addCookie(cookie); // response(응답) 에  다시 담아서 보내주면됨
        return "redirect:/";
    }
}



