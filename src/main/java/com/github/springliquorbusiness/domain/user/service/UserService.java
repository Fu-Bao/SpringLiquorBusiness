package com.github.springliquorbusiness.domain.user.service;

import com.github.springliquorbusiness.domain.user.dto.MyProfileDto;
import com.github.springliquorbusiness.domain.user.dto.SignupDto;
import com.github.springliquorbusiness.domain.user.entity.UserEntity;
import com.github.springliquorbusiness.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder bCryptPasswordEncoder;

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

        user.passwordEncode(bCryptPasswordEncoder);

        userRepository.save(user);
    }

    public MyProfileDto getMyPage(String email) {
        UserEntity user = userRepository.findByEmail(email).orElseThrow(
                () -> new RuntimeException("user not found")
        );

        return MyProfileDto.toMyPageMainDto(user);
    }
}
