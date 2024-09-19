package test.di08.javaconfig.mybatis;

import org.apache.ibatis.session.SqlSession;
import test.vo.MembersVo;

import java.util.List;

// 스프링에서는 SqlSession 라이프 사이클( 생성/종료)과 트랜잭선 처리를 스프링이 처리한다
public class MybatisDao {
    private SqlSession sqlSession;
    private final String NAMESPACE ="mybatis.MembersMapper.xml";

    public MybatisDao() {
    }

    public MybatisDao(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    public void setSqlSession(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    public int insert(MembersVo vo){
        return sqlSession.insert(NAMESPACE + ".insert", vo);
    }

    public int update(MembersVo vo ){
        return sqlSession.update(NAMESPACE+".update",vo);
    }

    public int delete(int num ){
        return sqlSession.delete(NAMESPACE+".delete",num);
    }
    public int selectOne(int num) {
        return sqlSession.selectOne(NAMESPACE+".selectOne"+num);
    }

    public List<MembersVo> selectAll() {
        return sqlSession.selectList(NAMESPACE + ".select");
    }


}
