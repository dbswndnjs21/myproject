package com.example.demo.controller;

import com.example.demo.dto.Member;
import com.example.demo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {

    @Autowired
    MemberService memberService;

    @GetMapping("/member/join")
    public String joinForm(@ModelAttribute Member member) {
        return "member/join";
    }

    @PostMapping("/member/join")
    public String join(@ModelAttribute Member member, BindingResult bindingResult, Model model) { // BindingResult는 위치도 중요함
        if (!StringUtils.hasText(member.getId())) {
            // 에러 담기 new FieldError("객체명", "필드명", "에러메세지")
            // 객체명은 @ModelAttribute인 경우 클래스명을 소문자로 받기때문에 member넣으면됨
            // 필드명은 객체(Member)에 존재하는 맴버변수 명을 사용해야한다
            bindingResult.addError((new FieldError("member", "id", "아이디를 입력하세요")));
        }
        if (!StringUtils.hasText(member.getPwd())) {
            bindingResult.addError((new FieldError("member", "pwd", "비밀번호를 입력하세요")));
        }
        if (member.getAge() > 150 || member.getAge() <0 ) {
            bindingResult.addError((new FieldError("member", "age", "150 미만을 입력하세요")));
        }

        if (bindingResult.hasErrors()) {
            return "member/join";
        }

        try {
            memberService.insert(member);
            model.addAttribute("result", "회원가입성공");
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("result", "회원가입실패");
        }
        return "member/result";
    }


}
