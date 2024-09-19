package com.example.demo.repository;

import com.example.demo.entity.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, String> {

    public Page<Member> findAll(Pageable page); // Pageable

    // limit : 몇개 , offset : 몇 페이지 부터
    @Query("select m from Member m where m.age>:age order by m.age desc limit :a offset :b")
    public List<Member> findList(@Param("age") int age, @Param("a") int a, @Param("b") int b);

    @Modifying // DML 작업 할때는 반드시 어노테이션을 설정해야함
    @Query("update Member m set m.age = m.age + 10 where m.id= :id")
    public int update(@Param("id")String id);

    @Query("select m from Member m where m.pwd = :pwd and m.email = :email")
//    @Query("select m from Member m where m.pwd = ?1 and m.email=?2") 이것도 가능
    public Member findId(@Param("pwd") String pwd, @Param("email") String email);

    // 이런식으로 사용하면 JPA가 유추 해서 값 반환해줌 -> 쿼리 메소드라 고함
    // findBy컬럼명
    public Member findByEmail(String email);
        
    // 이렇게도 됨
    public Member findByPwdAndEmail(String pwd, String email);

}
