package com.example.demo.dto;

import com.example.demo.entity.FileInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class FileInfoDto {
    private Long filenum;
    private String writer;
    private String title;
    private String content;
    private String orgfilename;
    private String savefilename;
    private long filesize;

    public FileInfoDto(FileInfo fileInfo) {
        this.filenum = fileInfo.getFilenum();
        this.writer = fileInfo.getWriter();
        this.title = fileInfo.getTitle();
        this.content = fileInfo.getContent();
        this.orgfilename = fileInfo.getOrgfilename();
        this.savefilename = fileInfo.getSavefilename();
        this.filesize = fileInfo.getFilesize();
    }

    public FileInfo toEntity() {
        FileInfo info = FileInfo.builder()
                .filenum(filenum)
                .writer(writer)
                .title(title)
                .content(content)
                .orgfilename(orgfilename)
                .savefilename(savefilename)
                .filesize(filesize)
                .build();
        return info;
    }

}
