package com.jhta.service;

import com.jhta.dao.MyUsersDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.vo.MyUsersVo;

import java.util.HashMap;
import java.util.List;
@Service
public class MyUsersService {

    @Autowired
    private MyUsersDao dao;

    public MyUsersService(MyUsersDao dao) {
        this.dao = dao;
    }

    public void setDao(MyUsersDao dao) {
        this.dao = dao;
    }

    public int insert(MyUsersVo vo) {
        return dao.insert(vo);
    }

    public  boolean isMember(HashMap<String, String> map) {
        MyUsersVo users = dao.isMember(map);
        if (users == null) {
            return false;
        } else {
            return true;
        }
    }

    public List<MyUsersVo> select(){
        return dao.select();
    }

}
