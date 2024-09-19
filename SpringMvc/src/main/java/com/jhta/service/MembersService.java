package com.jhta.service;

import com.jhta.dao.MembersDao;
import test.vo.MembersVo;

import java.util.List;

public class MembersService {
    private MembersDao dao;

    public MembersService(MembersDao dao) {
        this.dao = dao;
    }

    public int insert(MembersVo vo) {
        return dao.insert(vo);
    }

    public int update(MembersVo vo) {
        return dao.update(vo);
    }

    public int delete(int num) {
        return dao.delete(num);
    }

    public MembersVo selectOne(int num) {
        return dao.selectOne(num);
    }

    public List<MembersVo> select() {
        return dao.select();
    }
}
