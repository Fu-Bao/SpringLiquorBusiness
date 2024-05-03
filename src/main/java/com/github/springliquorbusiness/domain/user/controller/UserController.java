package com.github.springliquorbusiness.domain.user.controller;

import com.github.springliquorbusiness.domain.user.dto.LoginDto;
import com.github.springliquorbusiness.domain.user.dto.SignupDto;
import com.github.springliquorbusiness.domain.user.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
@RequiredArgsConstructor
@Tag(name = "유저 관련 API", description = "유저 서비스 관련 api 컨트롤러")
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    @Operation(summary = "이메일, 비밀번호, 유저네임으로 회원가입을 처리하는 API 엔드포인트")
    public ResponseEntity<?> signup(@RequestBody SignupDto signupDto) {
        userService.signup(signupDto);
        return ResponseEntity.ok("회원가입 완료");
    }

    @PostMapping
    @Operation(summary = "이메일, 비밀번호로 로그인을 처리하는 API 엔드포인트", description = "우선 토큰은 발급 안됨")
    public ResponseEntity<?> login(@RequestBody LoginDto loginDto) {
        userService.login(loginDto);
        return ResponseEntity.ok("로그인 완료");
    }
}
