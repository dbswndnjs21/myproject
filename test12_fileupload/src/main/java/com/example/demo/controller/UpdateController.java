package com.example.demo.controller;

import com.example.demo.dto.FileInfoDto;
import com.example.demo.dto.FileRequestDto;
import com.example.demo.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

@Controller
public class UpdateController {
    @Value("${file.path}")
    private String filePath;

    @Autowired
    private FileService fileService;

    @GetMapping("/file/update")
    public String updateForm(@RequestParam("filenum") long filenum, Model model) {
        FileInfoDto select = fileService.select(filenum);
        model.addAttribute("list", select);
        return "file/update";
    }

    @PostMapping("/file/update")
    public String update(FileRequestDto dto){
        MultipartFile file1 = dto.getFile1();
        try{
            FileInfoDto fileinfo = fileService.select(dto.getFilenum());
            if (!file1.isEmpty()) { // 수정할 파일이 전송된 경우
                File f = new File(filePath + File.separator + fileinfo.getSavefilename());
                if (f.exists() && f.delete()) {
                    System.out.println("파일 삭제 완료");
                }
                String orgFilename = file1.getOriginalFilename();
                String savefilename = UUID.randomUUID() + "_" + orgFilename;
                File destFile=new File(filePath + File.separator + savefilename);
                file1.transferTo(destFile);
                long filesize = file1.getSize();
                FileInfoDto updateDto = FileInfoDto.builder()
                        .filenum(dto.getFilenum())
                        .title(dto.getTitle())
                        .writer(dto.getWriter())
                        .content(dto.getContent())
                        .orgfilename(orgFilename)
                        .savefilename(savefilename)
                        .filesize(filesize)
                        .build();
                fileService.update(updateDto);


            } else { // 수정할 파일이 전송안된 경우 > 기존 파일 유지
                FileInfoDto updateDto = FileInfoDto.builder()
                        .filenum(dto.getFilenum())
                        .title(dto.getTitle())
                        .writer(dto.getWriter())
                        .content(dto.getContent())
                        .orgfilename(fileinfo.getOrgfilename())
                        .savefilename(fileinfo.getSavefilename())
                        .filesize(fileinfo.getFilesize())
                        .build();
                fileService.update(updateDto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/file/list?filenum=" + dto.getFilenum();
    }


}
