package com.github.springliquorbusiness.domain.user.service;

import com.github.springliquorbusiness.domain.user.dto.LoginDto;
import com.github.springliquorbusiness.domain.user.dto.MyProfileDto;
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
            throw new RuntimeException("user not found");
        }

        // 유저 email 중복 확인
        if (userRepository.existsByEmail(signupDto.getEmail())) {
            throw new RuntimeException("user not found");
        }

        UserEntity user = UserEntity.SignupToEntity(signupDto);

        userRepository.save(user);
    }

    public MyProfileDto getMyPage(String email) {
        UserEntity user = userRepository.findByEmail(email).orElseThrow(
                () -> new RuntimeException("user X")
        );

        return MyProfileDto.toMyPageMainDto(user);
    }
}
