    package com.example.demo.service;

import com.example.demo.dto.MyUser;
import com.example.demo.mybatis.MyUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;


@Service
public class MyUserService {

    @Autowired
    private MyUserMapper mapper;

    public MyUser selectOne(String id) {
        return mapper.selectOne(id);
    }
}
