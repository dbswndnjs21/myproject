package com.example.demo.repository;

import com.example.demo.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

//JpaRepository 상속 받으면 @Repository 안해줘도됨
public interface MemberRepositoryJPA extends JpaRepository<Member, String> { // <엔티티명, PK의 데이터형>
    // 인터페이스 끼리 상속은 extends임

    @Query("select m  from Member m  where m.id=:id")
    public Member select(@Param("id")String id);

    @Query("select m from Member m where m.id in :ids")
    public List<Member> findMember(@Param("ids") List<String> ids);

    @Query("select m from Member m where m.age >= :age")
    public List<Member> findMemberByAge(@Param("age")int age);

    @Query("select m from Member m where m.id = :id and m.password = :password")
    public Member findMemberByPassword(@Param("id")String id, @Param("password")String password);

}
