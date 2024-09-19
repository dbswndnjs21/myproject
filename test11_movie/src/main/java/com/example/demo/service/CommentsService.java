package com.example.demo.service;

import com.example.demo.dto.CommentsDto;
import com.example.demo.dto.PageResultDto;
import com.example.demo.entity.Comments;
import com.example.demo.entity.Movie;
import com.example.demo.repository.CommentsRepository;
import com.example.demo.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CommentsService {

    @Autowired
    private CommentsRepository commentsRepository;
    @Autowired
    private MovieRepository movieRepository;


    public CommentsDto save(CommentsDto commentsDto) {
        Optional<Movie> byId = movieRepository.findById(commentsDto.getMnum());
        Movie movie = byId.get();
        Comments comments = commentsDto.toEntity(movie);
        return new CommentsDto(commentsRepository.save(comments));
    }

    public void delete(Long cnum) {
        commentsRepository.deleteById(cnum);
    }

    public PageResultDto findByMnum(Long mnum, PageRequest pageable) {
        Page<Comments> pageList = commentsRepository.findByMnum(mnum, pageable);
        List<CommentsDto> clist = pageList.stream().map(m -> new CommentsDto(m)).toList();
        PageResultDto pageResultDto = new PageResultDto(clist, pageList.getNumber(), pageList.getTotalPages(), 5); // 페이지 갯수 5개
        return pageResultDto;
    }

    public CommentsDto findById(Long cnum) {
        Optional<Comments> byId = commentsRepository.findById(cnum);
        Comments comments = byId.get();
        return new CommentsDto(comments);
    }
}
