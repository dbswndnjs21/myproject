package com.jhta.controller;

import com.jhta.service.MembersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DeleteController {
    @Autowired
    MembersService membersService;

    @GetMapping("members/delete")
    public ModelAndView delete(int num) {
        ModelAndView mv = new ModelAndView("/members/result");
        String code = "success";
        try {
            membersService.delete(num);
        } catch (Exception e) {
            e.printStackTrace();
            code = "fail";
        }
        mv.addObject("code", code);
        return mv;
    }

    public String delete(int num, Model model) {
        try {
            membersService.delete(num);
            return "redirect:/members/list";
        } catch (Exception e) {
            model.addAttribute("code","error");
            return "members/result";
        }

    }
}
