package com.jhta.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SumController {

    @PostMapping("/sum")
    public ModelAndView sum(int num1 , int num2) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("home");
        int sum = num1 + num2;
        mv.addObject("result",sum);
        return mv;
    }
}
