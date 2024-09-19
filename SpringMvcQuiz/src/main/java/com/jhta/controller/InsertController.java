package com.jhta.controller;

import com.jhta.service.MyUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import test.vo.MyUsersVo;

@Controller
public class InsertController {

   @Autowired
   private MyUsersService myUsersService;

    @GetMapping("/myusers/insert")
    public String join() {
        System.out.println("test");
        return "users/insert";
    }

    @PostMapping("/myusers/insert")
    public ModelAndView insert(MyUsersVo vo) {
        String code = "success";
        try {
            myUsersService.insert(vo);
        } catch (Exception e) {
            code = "fail";
        }
        ModelAndView mv = new ModelAndView("users/result");
        mv.addObject("code", code);
        return mv;
    }
}
