package test.mybatis;

import test.vo.MembersVo;

import java.util.List;

// test.mybatis.MembersMapper.xml 와 같은 이름의 패키지에 같은 이름의 인터페이스를 만든다.
public interface MembersMapper {

    //test.mybatis.MembersMapper.xml 파일의 id 속성과 똑같은 이름으로 메소드를 만든다
    int insert(MembersVo vo);

    int update(MembersVo vo);

    int delete(int num);

    MembersVo selectOne(int num);

    List<MembersVo> select();
}
