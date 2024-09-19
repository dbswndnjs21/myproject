package com.example.demo.controller;

import com.example.demo.dto.MovieDto;
import com.example.demo.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private MovieService movieService;

    @GetMapping("/")
    public String movieList(Model model) {
        List<MovieDto> movieDtos = movieService.movieDtoList();
        model.addAttribute("list", movieDtos);
        return "home";
    }
}
