package com.jhta.controller;

import com.jhta.service.MyUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import test.vo.MyUsersVo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class ListController {

    @Autowired
    private MyUsersService myUsersService;

    @GetMapping("/users/list")
    public String listForm(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        String userSession = (String) session.getAttribute("username");
        System.out.println(userSession);
        if (userSession == null) {
            return "redirect:/login";
        } else {
            List<MyUsersVo> list = myUsersService.select();
            model.addAttribute("list", list);
            return "users/list";
        }
    }

}
