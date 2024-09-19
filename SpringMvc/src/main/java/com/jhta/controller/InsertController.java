package com.jhta.controller;

import com.jhta.service.MembersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import test.vo.MembersVo;

@Controller
public class InsertController {
    @Autowired
    private MembersService membersService;

    @GetMapping("/members/insert")
    public String join() {
        return "/members/insert";
    }

    @PostMapping("members/insert")
    public ModelAndView insert(MembersVo vo) { // MemversVo의 맴버 변수랑 name이랑 같으면 setter로 넣어줌
        // 생성자로 넣으면 뷰 이름이 됨 setViewName 이랑 동일함
        String code = "success";
        try {
            membersService.insert(vo);
        } catch (Exception e) {
            e.printStackTrace();
            code="error";
        }
        ModelAndView mv = new ModelAndView("members/result");
        mv.addObject("code", code);
        return mv;
    }
}
