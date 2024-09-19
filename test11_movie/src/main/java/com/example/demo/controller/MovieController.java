package com.example.demo.controller;

import com.example.demo.service.CommentsService;
import com.example.demo.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class MovieController {

    @Autowired
    private MovieService movieService;
    @Autowired
    private CommentsService commentsService;

    @GetMapping("/movie/detail")
    public String detail(Model model, @RequestParam("mnum") long mnum) {
        model.addAttribute("movie", movieService.select(mnum));
        return "movie/detail";
    }
}
