package com.jhta.controller;

import com.jhta.service.BoardService;
import com.jhta.util.PageUtil;
import oracle.jdbc.proxy.annotation.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import test.vo.BoardVo;

import java.util.HashMap;
import java.util.List;

@Controller
public class ListController {
    @Autowired
    private BoardService boardService;

    @RequestMapping("/board/list")
    public String list(Model model, @RequestParam(value = "pageNum", defaultValue = "1") int pageNum, String field, String keyword) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("keyword", keyword);
        map.put("field", field);
        int totalRowCount = boardService.count(map);  // Service 통해서 DB에서 가져올거임
        PageUtil pu = new PageUtil(pageNum, 5, 10, totalRowCount);
        int startRow = pu.getStartRow(); // 시작행 번호
        int endRow = pu.getEndRow(); //끝행번호
        map.put("startRow", startRow);
        map.put("endRow", endRow);
        List<BoardVo> list = boardService.list(map);
        model.addAttribute("pu", pu);
        model.addAttribute("list", list);
        model.addAttribute("keyword", keyword);
        model.addAttribute("field", field);
        return "board/list";
    }

}