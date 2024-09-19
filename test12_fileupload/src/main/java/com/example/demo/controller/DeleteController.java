package com.example.demo.controller;

import com.example.demo.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DeleteController {
    @Value("${file.path}")
    String filepath;

    @Autowired
    private FileService fileService;

    @GetMapping("/file/delete")
    public String delete(@RequestParam("filenum") long filenum) {
        System.out.println("타야해 : "  + filenum);
        fileService.delete(filenum,filepath);
        return "redirect:/file/list";
    }
}
