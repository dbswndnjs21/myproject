package com.example.demo.controller;

import com.example.demo.dto.MemberDto;
import com.example.demo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class FindIdController {

    @Autowired
    private MemberService memberService;

    @PostMapping("/findId")
    public ResponseEntity<MemberDto> findId(@RequestParam("pwd") String pwd, @RequestParam("email") String email) {
        System.out.println("pwd : " + pwd + " email : " + email);
        MemberDto id = memberService.findId(pwd, email);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
