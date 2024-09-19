package com.example.demo.service;

import com.example.demo.dto.Member;
import com.example.demo.mybatis.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;


@Service
public class MemberService {

    @Autowired
    private MemberMapper mapper;

    public int insert(Member member) {
        return mapper.insert(member);
    }

    public int count() {
        return mapper.count();
    }

    public List<Member> list(HashMap<String,Object> map) {
        return mapper.list(map);
    }

    public int delete(String id) {
        return mapper.delete(id);
    }

    public Member selectOne(String id) {
        return mapper.selectOne(id);
    }

    public int update(Member member) {
        return mapper.update(member);
    }
}
