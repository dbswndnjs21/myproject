package test.quiz.mybatis;

import org.apache.ibatis.session.SqlSession;
import test.quiz.vo.BoardVo;
import test.vo.MembersVo;

import java.util.List;

public class MboardDao {

    private SqlSession sqlSession;
    private final String NAMESPACE ="quiz.MboardMapper.xml";

    public void setSqlSession(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }
    public int insert(BoardVo vo){
        return sqlSession.insert(NAMESPACE + ".insert", vo);
    }

    public int update(BoardVo vo ){
        return sqlSession.update(NAMESPACE+".update",vo);
    }

    public int delete(int num ){
        return sqlSession.delete(NAMESPACE+".delete",num);
    }
    public int selectOne(int num) {
        return sqlSession.selectOne(NAMESPACE+".selectOne"+num);
    }

    public List<BoardVo> selectAll() {
        return sqlSession.selectList(NAMESPACE + ".select");
    }

}
