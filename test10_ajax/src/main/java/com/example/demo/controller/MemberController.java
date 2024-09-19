package com.example.demo.controller;


import com.example.demo.dto.MemberDto;
import com.example.demo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MemberController {
    @Autowired
    private MemberService memberService;

    @PostMapping("/member/join")
    public ResponseEntity<MemberDto> join(MemberDto dto) {
        MemberDto join = memberService.join(dto);
        return new ResponseEntity<MemberDto>(join, HttpStatus.OK);
    }

    @GetMapping("/member/list")
    public ResponseEntity<List<MemberDto>> list() {
        List<MemberDto> list = memberService.list();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
