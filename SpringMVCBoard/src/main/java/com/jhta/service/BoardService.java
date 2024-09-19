package com.jhta.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.mybatis.BoardMapper;
import test.vo.BoardVo;

import java.util.HashMap;
import java.util.List;

@Service
public class BoardService {
    @Autowired
    private BoardMapper mapper;

    public int insert(BoardVo vo) {
        return mapper.insert(vo);
    }

    public List<BoardVo>list(HashMap<String, Object> map) {
        return mapper.list(map);
    }

    public int count(HashMap<String, Object> map) {
        return mapper.count(map);
    }

    public int addHit(int num) {
        return mapper.addHit(num);
    }

    public BoardVo detail(int num) {
        return mapper.detail(num);
    }

    public BoardVo prev(int num) {
        return mapper.prev(num);
    }
    public BoardVo next(int num) {
        return mapper.next(num);
    }

}
