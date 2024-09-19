package com.example.demo.controller;

import com.example.demo.dto.FileInfoDto;
import com.example.demo.dto.MultiFileRequestDto;
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
import java.util.List;
import java.util.UUID;

@Controller
public class MultiFileUploadController {

    @Autowired
    private final FileService fileService;

    @Value("${file.path}")
    private String filePath;

    public MultiFileUploadController(FileService fileService) {
        this.fileService = fileService;
    }

    @GetMapping("/file/uploadFiles")
    public String uploadForm() {
        return "file/uploadFiles";
    }

    @PostMapping("/file/uploadFiles")
    public String upload(MultiFileRequestDto dto, Model model) {
        List<MultipartFile> list = dto.getFile1();
        for (MultipartFile multipartFile : list) {
            String orgFileName = multipartFile.getOriginalFilename();
            String saveFilename = UUID.randomUUID()+"_"+ orgFileName; // 난수로 저장할 파일명 변경
            long fileSize = multipartFile.getSize(); //파일크기
            try {
                File f = new File(filePath + File.separator + saveFilename); // 저장할 정보를 갖는 파일 객체
                multipartFile.transferTo(f); // 업로드한 파일을 f에 복사하기

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
        }
        return "result";
    }

}
