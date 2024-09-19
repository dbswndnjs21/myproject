package com.example.demo.controller;

import com.example.demo.dto.FileInfoDto;
import com.example.demo.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class FileListController {

    @Autowired
    private FileService fileService;

    @GetMapping("/file/list")
    public String list(Model model) {
        List<FileInfoDto> list = fileService.findAll();
        model.addAttribute("list", list);
        return "file/list";
    }
}
