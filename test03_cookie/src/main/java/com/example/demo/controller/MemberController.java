package com.example.demo.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MemberController {

    @GetMapping("/member/item")
    public String item(Model model, HttpServletRequest request) {
        List<String> list = new ArrayList<>();
        list.add("상품1");
        list.add("상품2");
        list.add("상품3");
        model.addAttribute("list", list);

        // 쿠키 값을 검사해서 id가 존재하는지 확인
        Cookie[] cookies = request.getCookies(); //배열로 받아옴
        if (cookies!=null) { // null 인지 검사하는게 좋음 -> 최초 요청은 null임
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("id")) {
                    model.addAttribute("id", cookie.getValue());
                    return "member/item";
                }
            }
        }
        return "redirect:/member/login";
    }
}