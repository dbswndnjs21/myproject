
package com.example.demo.service;

import com.example.demo.dto.MemberDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@Transactional
@Rollback(value = false) // @commit해도됨
public class MemberServiceTest {
    @Autowired private MemberService service;

    @Test
    void save() {
        service.join(new MemberDto("hello", "1234", "hello@", 10, null));
        service.join(new MemberDto("hell", "2345", "helo@", 20, null));
    }

    @Test
    void list() {
        List<MemberDto> list = service.list();
        list.forEach(m-> System.out.println(m));
    }

    @Test
    void update(){
        MemberDto dto = new MemberDto("hello", "1234", "hello@", 10, null);
        MemberDto update = service.update(dto);
        System.out.println(update);
    }

    @Test
    void delete(){
        service.delete("hello");
    }

    @Test
    void updateId(){
        MemberDto update = service.update(new MemberDto("hello", "434", "helo2345@", 10, null));
        System.out.println(update);
    }

    @Test
    void select(){
        MemberDto hello = service.selectOne("hello");
        System.out.println(hello);
    }
}
