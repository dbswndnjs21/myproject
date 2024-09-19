package com.jhta.dao;

import org.apache.ibatis.session.SqlSession;
import test.vo.MembersVo;

import java.util.List;

public class MembersDao {

    private SqlSession sqlSession;
    final String NAMESPACE = "test/mybatis/MembersMapper.xml";

    public void setSqlSession(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    public int insert(MembersVo vo) {
        return  sqlSession.insert(NAMESPACE + ".insert",vo);
    }

    public int update(MembersVo vo) {
        return  sqlSession.update(NAMESPACE + ".update",vo);
    }

    public int delete(int num) {
        return sqlSession.delete(NAMESPACE + ".delete",num);
    }

    public MembersVo selectOne(int num) {
        return sqlSession.selectOne(NAMESPACE + ".selectOne",num);
    }

    public List<MembersVo> select() {
        return sqlSession.selectList(NAMESPACE + ".select");
    }
}
