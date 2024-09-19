package com.example.demo.controller;

import com.example.demo.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FileInfoController {

    @Autowired
    private FileService fileService;

    @GetMapping("/file/info")
    public String fileInfo(@RequestParam("filenum")long filenum, Model model) {
        model.addAttribute("dto", fileService.select(filenum));
        return "file/info";
    }


}

