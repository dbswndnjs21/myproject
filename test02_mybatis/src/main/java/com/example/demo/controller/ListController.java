package com.example.demo.controller;

import com.example.demo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;

@Controller
public class ListController {
    @Autowired
    private MemberService memberService;

    @GetMapping("/member/list")
    public String list(@RequestParam(name = "page", defaultValue = "1") int page, Model model) {
        int start = (page - 1) *3 +1;
        int end = start + 2;

        int startPage = (page - 1)/3*3 +1;
        int endPage = startPage + 2;
        int pageCount = (int)Math.ceil(memberService.count()/3.0);
        if (endPage > pageCount) {
            endPage = pageCount;
        }

        HashMap<String,Object> map = new HashMap<>();
        map.put("startRow", start);
        map.put("endRow", end);

        model.addAttribute("startPage", startPage );
        model.addAttribute("endPage", endPage );
        model.addAttribute("pageCount", pageCount);
        model.addAttribute("list", memberService.list(map));
        model.addAttribute("page", page);
        return "member/list";
    }
}
