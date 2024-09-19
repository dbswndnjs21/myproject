package com.example.demo.controller;

import com.example.demo.dto.CommentsDto;
import com.example.demo.dto.PageResultDto;
import com.example.demo.service.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentsController {

    @Autowired
    private CommentsService commentsService;

    @PutMapping("/comments/insert")
    public ResponseEntity<String> insert(@RequestBody CommentsDto commentsDto) {
        System.out.println("테스트 : " + commentsDto);
        String result = "success(insert)";
        try {
            CommentsDto save = commentsService.save(commentsDto);
        } catch (Exception e) {
            result = "fail(insert)";
            e.printStackTrace();
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/comments/list/{mnum}/{page}")
    public ResponseEntity<PageResultDto> list(@PathVariable("mnum") long mnum, @PathVariable("page") int page) {
        PageRequest pageable = PageRequest.of(page, 3, Sort.by("cnum").descending());
        PageResultDto byMnum = commentsService.findByMnum(mnum, pageable);
        return new ResponseEntity<>(byMnum, HttpStatus.OK);
    }

    @DeleteMapping("/comments/delete")
    public ResponseEntity<String> delete(@RequestParam("cnum") long cnum) {
        System.out.println("씨넘 : " + cnum);
        String result = "success(delete)";
        try {
            commentsService.delete(cnum);
        } catch (Exception e) {
            result = "fail(delete)";
            e.printStackTrace();
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PutMapping("/comments/update/{cnum}")
    public ResponseEntity<CommentsDto> update(@PathVariable("cnum")long cnum) {
        CommentsDto dto = commentsService.findById(cnum);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
}
