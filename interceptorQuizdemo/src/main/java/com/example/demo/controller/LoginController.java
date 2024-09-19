package com.example.demo.controller;

import com.example.demo.dto.MyUser;
import com.example.demo.service.MyUserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @Autowired
    private MyUserService myUserService;

    @GetMapping("/member/login")
    public String loginForm() {
        return "member/login";
    }

    @PostMapping("/member/login")
    public String login(@RequestParam("id") String id, @RequestParam("pwd") String password, HttpServletRequest request) {
        MyUser myUser = myUserService.selectOne(id);
        String userId = myUser.getId();
        String userPwd = myUser.getPwd();
        if (id.equals(userId) && password.equals(userPwd)) {
            request.getSession().setAttribute("id", id);
            request.getSession().setAttribute("role", myUser.getRole());
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