package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Score {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long scoreId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Student studentId;
    private String subject;
    private int score;
    private String semester;
}
