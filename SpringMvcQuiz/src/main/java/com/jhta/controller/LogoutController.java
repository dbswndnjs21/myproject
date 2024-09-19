package com.jhta.controller;

import com.jhta.service.MyUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LogoutController {

    @Autowired
    private MyUsersService myUsersService;

    @GetMapping("/logout")
    public String logout(HttpServletRequest request){
        // request.getSession(); -> ()안에는 true가 기본이고 false를 하면 기존세션을 사용함
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        return "redirect:/";
    }
}
