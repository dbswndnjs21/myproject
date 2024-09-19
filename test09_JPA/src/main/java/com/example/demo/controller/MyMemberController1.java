package com.example.demo.controller;

import com.example.demo.dto.MemberDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController // @ResponseBody 로 응답함
public class MyMemberController1 {

    @GetMapping("/member1")
    public MemberDto info() {
        MemberDto dto = new MemberDto("hello", "1234", "hello@", 10, null);
        return dto; // 리턴 된 값으로 바로 응답한다는 소리 ( 제이슨 타입으로 받음)
    }

    @GetMapping("/list1")
    public List<MemberDto> list(){
        ArrayList<MemberDto>  list = new ArrayList<>();
        list.add(new MemberDto("hello", "1234", "hello@", 10, null));
        list.add(new MemberDto("hell2o2", "123222224", "hel222lo@", 10, null));
        return list;
    }

}
