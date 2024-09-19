package com.jhta.controller;

import com.jhta.service.MembersService;
import oracle.jdbc.proxy.annotation.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import test.vo.MembersVo;

import java.util.List;

@Controller
public class UpdateController {
    @Autowired
    MembersService membersService;

    @GetMapping("/members/update")
    public ModelAndView getUpdate(int num) {
        MembersVo vo = membersService.selectOne(num);
        ModelAndView mv = new ModelAndView("/members/update");
        mv.addObject("vo", vo);
        return mv;
    }

    @PostMapping("/members/update")
    public ModelAndView update(MembersVo vo) {
        String code = "success";
        try {
            membersService.update(vo);
        } catch (Exception e) {
            e.printStackTrace();
            code = "fail";
        }
        ModelAndView mv = new ModelAndView("/members/list");
        List<MembersVo> list = membersService.select();
        mv.addObject("list", list);
        return mv;
    }


}
