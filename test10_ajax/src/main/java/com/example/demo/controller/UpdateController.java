package com.example.demo.controller;

import com.example.demo.dto.MemberDto;
import com.example.demo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UpdateController {

    @Autowired
    private MemberService memberService;


    @GetMapping("/member/findById/{id}")
    public ResponseEntity<MemberDto> findById(@PathVariable("id") String id) {
        MemberDto memberDto = memberService.selectOne(id);
        return new ResponseEntity(memberDto, HttpStatus.OK);
    }



    //@RequestBody :파라미터를 json타입으로 받을때,
    // PutMapping : update 하고자 할때
    @PutMapping("/member/update")
    public ResponseEntity<String> update(@RequestBody MemberDto dto){
        String result="success";
        try {
            memberService.update(dto);
        }catch (Exception e) {
            System.out.println(e.getMessage());
            result="fail";
        }
        return new ResponseEntity<String>(result,HttpStatus.OK);
    }
}
