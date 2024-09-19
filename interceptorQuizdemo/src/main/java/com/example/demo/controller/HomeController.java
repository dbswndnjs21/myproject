package com.example.demo.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(HttpServletRequest request,Model model) {
        HttpSession session = request.getSession();
        String msg = (String) session.getAttribute("msg");
        model.addAttribute("msg", msg);
        return "home";
    }
}
