package com.example.demo.controller;

import com.example.demo.dto.FileInfoDto;
import com.example.demo.dto.FileRequestDto;
import com.example.demo.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
public class FileUploadController {
    
    @Value("${file.path}") // properties에 설정한 경로 값 가져오기
    private String filePath;

    @Autowired
    private FileService fileService;

    @GetMapping("/file/upload")
    public String uploadForm() {
        return "file/upload";
    }

    @PostMapping("/file/upload")
    public String upload(FileRequestDto dto, Model model){
        MultipartFile file1 = dto.getFile1();
        File destFile = new File(filePath);
        if(!destFile.exists()) destFile.mkdir(); // 폴더를 생성
        String orgFileName = file1.getOriginalFilename();
        String saveFilename = UUID.randomUUID()+"_"+ orgFileName; // 난수로 저장할 파일명 변경
        long fileSize = file1.getSize(); //파일크기
        try {
            File f = new File(filePath + File.separator + saveFilename); // 저장할 정보를 갖는 파일 객체
            file1.transferTo(f); // 업로드한 파일을 f에 복사하기

            FileInfoDto vo = FileInfoDto.builder()
                    .writer(dto.getWriter())
                    .title(dto.getTitle())
                    .content(dto.getContent())
                    .savefilename(saveFilename)
                    .orgfilename(orgFileName)
                    .filesize(fileSize)
                    .build();
            fileService.insert(vo);
            model.addAttribute("result", "success");
        } catch (IOException e) {
            e.printStackTrace();
            model.addAttribute("result", "fail");
        }

        return "result";
    }

}
