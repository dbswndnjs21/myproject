package test.quiz.jdbc;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import test.quiz.vo.BoardVo;
import test.vo.MembersVo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class MboardDao {
    JdbcTemplate jdbcTemplate;

    public MboardDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // jdbc select 하는 부분 내일 오면 해보기
    public List<BoardVo> select() {
        String sql = "select * from mboard";
        RowMapper<BoardVo> rowMapper = new RowMapper() {
            @Override
            public BoardVo mapRow(ResultSet rs, int rowNum) throws SQLException {
                BoardVo vo = new BoardVo();
                vo.setNum(rs.getInt("num"));
                vo.setWriter(rs.getString("writer"));
                vo.setTitle(rs.getString("title"));
                vo.setContent(rs.getString("content"));
                return vo;
            }
        };
        List<BoardVo> list = jdbcTemplate.query(sql, rowMapper);
        return list;
    }

    public BoardVo select(int num) {
        String sql = "select * from mboard where num = ?";
        RowMapper<BoardVo> rowMapper = new RowMapper<BoardVo>() {
            @Override
            public BoardVo mapRow(ResultSet rs, int rowNum) throws SQLException {
                BoardVo vo = new BoardVo();
                vo.setNum(rs.getInt("num"));
                vo.setWriter(rs.getString("writer"));
                vo.setTitle(rs.getString("title"));
                vo.setContent(rs.getString("content"));
                return vo;
            }
        };
        return jdbcTemplate.queryForObject(sql,rowMapper,num);
    }
}
