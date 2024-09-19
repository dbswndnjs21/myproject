package com.example.demo.mybatis;

import com.example.demo.dto.MyUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;


// @Mapper를 해주고 xml과 패키지 경로가 같으면 id를 인식해서 자동으로 mybatis가 해당 sql로 감
// 루트 아래에 경로에 있을경우는 따로 @MapperScan을 안해줘도됨
@Mapper
public interface MyUserMapper {
    // 인터페이스의 메서드 이름은 xml의 id와 동일해야함
    MyUser selectOne(String id);
}
