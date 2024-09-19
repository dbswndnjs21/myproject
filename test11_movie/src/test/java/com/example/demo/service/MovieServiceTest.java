package com.example.demo.service;

import com.example.demo.dto.MovieDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@Transactional
@Commit
public class MovieServiceTest {
    
    @Autowired
    private MovieService movieService;

    @Test
    public void save() {
        MovieDto movieDto = new MovieDto(0L,"제목2","내용2","작성자2");
        MovieDto save = movieService.save(movieDto);
        System.out.println("save 결과 값 : " + save);
    }

    @Test
    public void select() {
        MovieDto select = movieService.select(1);
        System.out.println("select 결과값 : " + select);
    }

    @Test
    public void movieDtoList() {
        List<MovieDto> movieDtos = movieService.movieDtoList();
//        for (MovieDto movieDto : movieDtos) {
//            System.out.println(movieDto);
//        }
        movieDtos.forEach(System.out::println);
    }
}
