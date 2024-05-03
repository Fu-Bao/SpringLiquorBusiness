package com.github.springliquorbusiness.domain.user.service;

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

    @Transactional
    public void signup(SignupDto signupDto) {
        // 유저 name 중복 확인
//        if (userRepository.existsByUsername(signupDto.getUsername())) {
//            throw new AppException(ErrorCode.USERNAME_DUPLICATED.getMessage(), ErrorCode.USERNAME_DUPLICATED);
//        }
//
//        // 유저 id 중복 확인
//        if (userRepository.existsByEmail(signupDto.getEmail())) {
//            throw new AppException(ErrorCode.USER_EMAIL_DUPLICATED.getMessage(), ErrorCode.USER_EMAIL_DUPLICATED);
//        }

        UserEntity user = UserEntity.SignupToEntity(signupDto);

        userRepository.save(user);
    }
}
