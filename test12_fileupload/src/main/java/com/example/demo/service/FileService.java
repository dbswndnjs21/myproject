package com.example.demo.service;

import com.example.demo.dto.FileInfoDto;
import com.example.demo.entity.FileInfo;
import com.example.demo.repository.FileInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class FileService {

    @Autowired
    private FileInfoRepository fileInfoRepository;
    @Autowired
    private DataSourceTransactionManagerAutoConfiguration dataSourceTransactionManagerAutoConfiguration;

    public FileInfoDto insert(FileInfoDto fileInfoDto) {
        return new FileInfoDto(fileInfoRepository.save(fileInfoDto.toEntity()));
    }

    public List<FileInfoDto> findAll() {
        List<FileInfo> list = fileInfoRepository.findAll();
        return list.stream().map(t -> new FileInfoDto(t)).toList();
    }

//  list.stream(): list라는 리스트를 스트림으로 변환합니다. 스트림은 데이터의 흐름을 처리하는 방법입니다.
//  .map(t -> new FileInfoDto(t)): 스트림의 각 요소(t)를 FileInfoDto 객체로 변환합니다. 즉, 리스트의 각 요소를 FileInfoDto 타입으로 바꾸는 작업입니다.
//  .toList(): 변환된 요소들을 다시 리스트로 모읍니다.
//  결과적으로, 이 코드는 원래 리스트의 각 요소를 FileInfoDto 객체로 변환하여 새로운 리스트를 반환하는 것입니다.


    public FileInfoDto select(Long filenum) {
        return new FileInfoDto(fileInfoRepository.findById(filenum).get());
    }

    public void delete(Long filenum, String filePath) {
        Optional<FileInfo> byId = fileInfoRepository.findById(filenum);
        FileInfo fileInfo = byId.get();

        Path path = Paths.get(filePath, fileInfo.getSavefilename());
        System.out.println(path);
        fileInfoRepository.deleteById(filenum);
        try {
            Files.deleteIfExists(path);
            System.out.println("파일이 성공적으로 삭제되었습니다: ");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("파일 삭제에 실패했습니다: ");
        }
    }

    public FileInfoDto update(FileInfoDto dto) {
        FileInfo file = fileInfoRepository.findById(dto.getFilenum()).get();
        file.setContent(dto.getContent());
        file.setFilesize(dto.getFilesize());
        file.setOrgfilename(dto.getOrgfilename());
        file.setSavefilename(dto.getSavefilename());
        file.setTitle(dto.getTitle());
        file.setWriter(dto.getWriter());
        return new FileInfoDto(file);
    }

}
