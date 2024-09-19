package com.example.demo.service;

import com.example.demo.dto.MovieDto;
import com.example.demo.entity.Movie;
import com.example.demo.repository.MovieRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public MovieDto save(MovieDto movieDto) {
        Movie movie = movieDto.toEntity();
        return new MovieDto(movieRepository.save(movie));
    }

    public MovieDto select(long mnum) {
        Movie movie = movieRepository.findById(mnum).get();
        return new MovieDto(movie);
    }

    public List<MovieDto> movieDtoList(){
        List<Movie> movies = movieRepository.findAll();
        return movies.stream().map(t -> new MovieDto(t)).toList();
    }


}
