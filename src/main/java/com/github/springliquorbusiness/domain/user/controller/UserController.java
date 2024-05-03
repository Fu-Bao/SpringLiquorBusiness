package com.github.springliquorbusiness.domain.user.controller;

import com.github.springliquorbusiness.domain.user.dto.SignupDto;
import com.github.springliquorbusiness.domain.user.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    @Operation(summary = "아이디, 비밀번호, 유저네임으로 회원가입을 처리하는 API 엔드포인트")
    public ResponseEntity<?> signup(@RequestBody SignupDto signupDto) {
        userService.signup(signupDto);
        return ResponseEntity.ok("회원가입 완료");
    }
}
