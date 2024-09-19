package com.jhta.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    
    // get 방식 처리할때 이렇게 씀
    @GetMapping("/")
    public String home(){
        return "home"; // String으로 리턴하면 뷰이름됨 -> 이 값을 디스패처 서블릿이 받음
    }
}
