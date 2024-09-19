package com.example.demo.dto;

import com.example.demo.entity.Comments;
import com.example.demo.entity.Movie;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentsDto {
    private Long cnum;
    private Long mnum;
    private String id;
    private String comments;

    public CommentsDto(Comments comments) {
        this.cnum = comments.getCnum();
        this.mnum = comments.getMovie().getMnum();
        this.id = comments.getId();
        this.comments = comments.getComments();
    }

    public Comments toEntity(Movie movie) {
        Comments c = Comments.builder()
                .cnum(cnum)
                .movie(movie)
                .id(id)
                .comments(comments)
                .build();
        return c;

    }
}
