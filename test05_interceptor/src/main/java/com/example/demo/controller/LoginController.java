package com.example.demo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
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
    public String login(@RequestParam("id") String id, @RequestParam("pwd") String password, HttpServletRequest request) {
        if (id.equals("hello") && password.equals("1234")) {
            request.getSession().setAttribute("id", id);
            return "redirect:/";
        }
        return "member/login";
    }

    @GetMapping("/member/logout")
    public String logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return "redirect:/";
    }
}