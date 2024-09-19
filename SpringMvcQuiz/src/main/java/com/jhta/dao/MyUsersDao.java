package com.jhta.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import test.vo.MyUsersVo;

import java.util.HashMap;
import java.util.List;

@Repository
public class MyUsersDao {

    @Autowired
    private SqlSession sqlSession;
    private final String NAMESPACE = "MyUsersMapper.xml";

    public void setSqlSession(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    public int insert(MyUsersVo vo){
        return sqlSession.insert(NAMESPACE+".insert",vo);
    }

    public MyUsersVo isMember(HashMap<String, String> map) {
        return sqlSession.selectOne(NAMESPACE + ".isMember",map);
    }

    public List<MyUsersVo> select() {
        return sqlSession.selectList(NAMESPACE + ".select");
    }

}
