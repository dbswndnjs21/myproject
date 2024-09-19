package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FileRequestDto {
    private Long filenum;
    private String writer;
    private String title;
    private String content;
    private MultipartFile file1; // 여기 변수명은 html에 name값과 같아야함
}
