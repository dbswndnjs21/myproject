package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Date;

/*
    FetchType : JPA가 하나의 Entity를 조회할때, 연관관계에 있는 객체들을 어떻게 가져올 것이냐를 나타내는 설정값
    @xxToxx ( fetch = fetchType.EAGER ) :  즉시 로딩 -> 데이터를 조회할 때, 연관된 모든 객체의 데이터까지 한번에 불러옴
    -> ex) Boarㅇ에서 title과 content만 필요해도 user까지 조회함
    @xxToxx(fetch = FetchType.LAZY): 지연로딩 -> 필요한 시점에 연관된 객체의 데이터를 불러옴
    -> 사용을 해야만 조회하는것
*/
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long num;
    @ManyToOne(fetch = FetchType.LAZY) // board 기준 다대일
    // FetchType.LAZY 는 MyUser를 사용할때 만 테이블 정보를 받아옴
    @JoinColumn(name = "username")
    private MyUser user;
    private String title;
    @Lob
    private String content;
    @CreationTimestamp
    private Date regdate;
}
