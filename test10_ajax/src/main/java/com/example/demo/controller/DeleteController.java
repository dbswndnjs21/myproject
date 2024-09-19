package com.example.demo.controller;

import com.example.demo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class DeleteController {
    @Autowired
    private MemberService memberService;

    @DeleteMapping("/member/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") String id) {
        String result = "success1111";
        try{
            memberService.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            result = "fail23232";
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
