package test.di07.jdbc;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import test.vo.MembersVo;

import java.lang.reflect.Member;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class JdbcDao {
    private JdbcTemplate jdbcTemplate;

    public JdbcDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int insert(MembersVo vo) {
        String sql = "insert into members values (?, ?, ?, ?, sysdate)";
        int n = jdbcTemplate.update(sql, vo.getNum(), vo.getName(), vo.getPhone(), vo.getAddr());
        // update() 는 가변인자 object 라서 ? 갯수 만큼 값 넣어주면 됨 배열로 알아서 들어감
        return n;
    }

    public int delete(int num) {
        String sql = "delete from members where num = ? ";
        int n = jdbcTemplate.update(sql, num);
        return n;
    }

    public int update(MembersVo vo) {
        String sql = "update mebmers set name = ?, phone = ?, addr = ? where num = ?";
        int n = jdbcTemplate.update(sql, vo.getName(), vo.getPhone(), vo.getAddr(), vo.getNum());
        return n;
    }

    public List<MembersVo> select() {
        RowMapper rowMapper = new RowMapper() {
            @Override
            public MembersVo mapRow(ResultSet rs, int rowNum) throws SQLException {
                MembersVo vo = new MembersVo();
                vo.setNum(rs.getInt("num"));
                vo.setName(rs.getString("name"));
                vo.setPhone(rs.getString("phone"));
                vo.setAddr(rs.getString("addr"));
                return vo;
            }
        };
        String sql = "select * from members";
        List<MembersVo> list  = jdbcTemplate.query(sql, rowMapper);
        return list;
    }

    public MembersVo select(int num) {
        String sql = "select * from members where num = ?";
        // 한명 정보 얻어오기
        RowMapper<MembersVo> rowMapper = new RowMapper() {
            @Override
            public MembersVo mapRow(ResultSet rs, int rowNum) throws SQLException {
                MembersVo vo = new MembersVo();
                vo.setNum(rs.getInt("num"));
                vo.setName(rs.getString("name"));
                vo.setPhone(rs.getString("phone"));
                vo.setAddr(rs.getString("addr"));
                return vo;
            }
        };
        // 얘는 List에 담지않고 그냥 보내줌
        return jdbcTemplate.queryForObject(sql, rowMapper, num);

    }


}
