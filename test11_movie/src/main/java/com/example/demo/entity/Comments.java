package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString(exclude = {"movie"})
@Builder
@Entity
public class Comments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cnum;
    @ManyToOne
    @JoinColumn(name="mnum")
    private Movie movie;
    private String id;
    private String comments;
}
