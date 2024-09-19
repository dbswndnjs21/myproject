package com.example.demo.controller;

import com.example.demo.dto.BoardDto;
import com.example.demo.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BoardDeleteController {

    @Autowired
    private BoardService boardService;

    @GetMapping("/board/delete")
    public String boardDelete(BoardDto boardDto, RedirectAttributes redirectAttributes) {
        boardService.delete(boardDto);
        // 아래 코드를 사용하면 리다이렉트로 보내도 msg값을 쓸수있음
        redirectAttributes.addFlashAttribute("msg", "삭제완료");
        return "redirect:/board/list";
    }
}
