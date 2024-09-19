package com.jhta.controller;

import com.jhta.service.MyUsersService;
import oracle.jdbc.proxy.annotation.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

@Controller
public class LoginController {

    @Autowired
    private MyUsersService myUsersService;

    @GetMapping("/login")
    public String loginForm() {
        return "users/login";
    }

    @PostMapping("/login")
    public String login(String username, String password, HttpServletRequest request, Model model) {
        HashMap<String, String> map = new HashMap<>();
        map.put("username", username);
        map.put("password", password);
        boolean result = myUsersService.isMember(map);
        if (result) {
            // 회원인 경우 -> 세션에 값저장후 home으로
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            return "redirect:/";
        } else {
            model.addAttribute("errMsg", "아이디 또는 비밀번호가 일치하지 않습니다");
            return "users/login";
        }
    }
}
