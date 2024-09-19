package com.example.demo.dto;

import com.example.demo.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MemberDto {
    private String id;
    private String pwd;
    private String email;
    private int age;
    private Date regdate;

    // 엔티티 값을 dto로
    public MemberDto(Member member) {
        this.id = member.getId();
        this.pwd = member.getPwd();
        this.email = member.getEmail();
        this.age = member.getAge();
        this.regdate = member.getRegdate();
    }

    public Member toEntity(){
//        Member m = new Member(id,pwd,email,age,regdate);
        // 엔티티에 Builder 어노테이션이 있으면 아래와 같은 방법으로 사용
        // 아래처럼하면 순서와 상관없이 값이 들어감(생성자와 차이점)
        Member m = Member.builder()
                .id(this.id)
                .pwd(this.pwd)
                .email(this.email)
                .age(this.age)
                .regdate(this.regdate).build();
        return  m;
    }
}
