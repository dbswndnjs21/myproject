package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepository; 
    @Autowired
    private PasswordEncoder passwordEncoder; //비밀번호를 암호화 하기 위한 객체 -> 사용을 위해선 Bean 등록해야함
    
    public void save(User user) {
        String password = user.getPassword();
        String encodePassword = passwordEncoder.encode(password); // 암호환 한 코드
        user.setPassword(encodePassword);
        userRepository.save(user);
    }

    public boolean isMember(String username, String pwd) {
        // DB에 저장된 암호화된 password 가져오ㅓ기
        String encodePassword = userRepository.findByUsername(username).getPassword();
        // matchs 메소드 : 사용자가 입력한 비밀번호(암호화 안된 비밀번호)와 암호화된 비밀번호 검사하기
        if (passwordEncoder.matches(pwd, encodePassword)) {
            return true;
        } else {
            return false;
        }
    }
}
