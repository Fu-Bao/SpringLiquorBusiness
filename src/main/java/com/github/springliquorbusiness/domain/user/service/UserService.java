package com.github.springliquorbusiness.domain.user.service;

import com.github.springliquorbusiness.domain.user.dto.LoginDto;
import com.github.springliquorbusiness.domain.user.dto.SignupDto;
import com.github.springliquorbusiness.domain.user.entity.UserEntity;
import com.github.springliquorbusiness.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void signup(SignupDto signupDto) {
        // 유저 name 중복 확인
        if (userRepository.existsByUsername(signupDto.getUsername())) {
            throw new RuntimeException("안돼");
        }

        // 유저 email 중복 확인
        if (userRepository.existsByEmail(signupDto.getEmail())) {
            throw new RuntimeException("안돼");
        }

        UserEntity user = UserEntity.SignupToEntity(signupDto);

        userRepository.save(user);
    }

    public void login(LoginDto loginDto) {
        userRepository.findByEmail(loginDto.getEmail()).orElseThrow(
                () -> new ArithmeticException("안돼")
        );
    }
}
