package com.example.demo.service;

import com.example.demo.dto.BoardDto;
import com.example.demo.dto.MemberDto;
import com.example.demo.entity.Board;
import com.example.demo.entity.Member;
import com.example.demo.repository.BoardRepository;
import com.example.demo.repository.MemberRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MemberService {
     @Autowired
     MemberRepository memberRepository;

    public MemberDto join(MemberDto dto) {
        Member member = dto.toEntity();
        Member m = memberRepository.save(member);
        return new MemberDto(m);
    }

    public List<MemberDto> list() {
        List<Member> mlist = memberRepository.findAll();
        List<MemberDto> list1 = mlist.stream().map(m -> new MemberDto(m)).toList();
        return list1;
    }

    public void delete(String id ) {
        memberRepository.deleteById(id);
    }

    public MemberDto selectOne(String id) {
        Optional<Member> byId = memberRepository.findById(id);
        return new MemberDto(byId.get());
    }

    public MemberDto update(MemberDto dto) {
        // 업데이트 할 내용들을 dto에 담고
        // 가져온 dto의 id로 조회한 후
        // member에 set으로 조회한 결과값을 넣어줌
        Optional<Member> byId = memberRepository.findById(dto.getId());
        Member member = byId.get();
        member.setAge(dto.getAge());
        member.setEmail(dto.getEmail());
        return new MemberDto(member);
    }


}
