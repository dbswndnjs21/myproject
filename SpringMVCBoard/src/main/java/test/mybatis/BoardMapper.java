package test.mybatis;

import test.vo.BoardVo;

import java.util.HashMap;
import java.util.List;

// test.mybatis.BoardMapper.xml 와 같은 이름의 패키지에 같은 이름의 인터페이스를 만든다.
public interface BoardMapper {

//    //test.mybatis.BoardMapper.xml 파일의 id 속성과 똑같은 이름으로 메소드를 만든다
    int insert(BoardVo vo);

    int count(HashMap<String,Object> map);

    List<BoardVo> list(HashMap<String,Object> map);

    int addHit(int num);

    BoardVo detail(int num);

    BoardVo prev(int num);

    BoardVo next(int num);

}
