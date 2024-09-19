package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SampleController {

    @GetMapping("/member/list")
    public String list() {
        return "member/list";
    }

    @GetMapping("/sample/all")
    public String all() {
        return "sample/all";
    }

    @GetMapping("/admin/main")
    public String main() {
        return "admin/main";
    }



}
