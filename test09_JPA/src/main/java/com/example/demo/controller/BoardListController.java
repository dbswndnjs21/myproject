package com.example.demo.controller;

import com.example.demo.dto.PageResultDto;
import com.example.demo.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardListController {

    @Autowired
    private BoardService boardService;

    @GetMapping("/board/list")
    public String boardList(@PageableDefault(size = 3,sort = "num", direction = Sort.Direction.DESC) Pageable pageable, Model model) {
        PageResultDto result = boardService.list(pageable);

        System.out.println("result = > " + result);

        model.addAttribute("list", result.getList());
        model.addAttribute("startPage", result.getStartPage());
        model.addAttribute("endPage", result.getEndPage());
        model.addAttribute("pageCount", result.getTotalPageCount());
        model.addAttribute("page", result.getPage());

        return "board/list";

    }

}
