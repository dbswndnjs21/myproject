package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Setter
@Getter
@ToString( of = { "num", "title", "content", "regdate" }) // of -> tostring에 해당 변수만 사용
@Builder
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // autoincrement
    private Long num; // 글번호
    @ManyToOne
    @JoinColumn(name="id")
    private Member member;
    private String title;
    @Lob
    private String content;
    @CreationTimestamp
    private LocalDateTime regdate;
}
