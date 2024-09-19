package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Member {
    @Id // pk에 해당되는 칼럼에
    private String id;
    @Column(name="pwd")
    public String password;
    private int age;
    private String email;
}
