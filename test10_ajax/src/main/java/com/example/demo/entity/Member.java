package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Member {
    @Id
    private String id;
    @Column(length = 10) // 안해주면 255로 들어가는데 설정해준거
    private String pwd;
    private String email;
    private int age;
    @CreationTimestamp
    private Date regdate;
}
