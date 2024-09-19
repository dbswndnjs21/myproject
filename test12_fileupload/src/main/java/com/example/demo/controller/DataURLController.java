package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.UrlResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.net.MalformedURLException;

@RestController
public class DataURLController {
    /*
       Resource 인터페이스 : Resource에 대한 접근을 추상화하기 위한 인터페이스
       UrlResource : URL 방식을 통해서 리소스의 위치를 알려주는 Resource 객체
    */

    @Value("${file.path}")
    private String filePath;


    @GetMapping("/images/{filename}")
    public UrlResource showImage(@PathVariable String filename) throws MalformedURLException {
        return new UrlResource("file:" + filePath + filename);
    }
}
