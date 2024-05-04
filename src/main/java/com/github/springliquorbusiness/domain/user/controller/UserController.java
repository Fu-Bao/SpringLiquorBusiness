package com.github.springliquorbusiness.domain.user.controller;

import com.github.springliquorbusiness.domain.auth.entity.CustomUserDetails;
import com.github.springliquorbusiness.domain.user.dto.LoginDto;
import com.github.springliquorbusiness.domain.user.dto.MyProfileDto;
import com.github.springliquorbusiness.domain.user.dto.SignupDto;
import com.github.springliquorbusiness.domain.user.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@Tag(name = "유저 관련 API", description = "유저 서비스 관련 api 컨트롤러")
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    @Operation(summary = "이메일, 비밀번호, 유저네임으로 회원가입을 처리하는 API")
    public ResponseEntity<?> signup(@RequestBody SignupDto signupDto) {
        userService.signup(signupDto);
        return ResponseEntity.ok("회원가입 완료");
    }

    @GetMapping("/my-page")
    @Operation(summary = "유저의 마이페이지를 확인하는 API")
    public ResponseEntity<MyProfileDto> myPageMain(@AuthenticationPrincipal CustomUserDetails user) {
        String email = user.getUsername();
        MyProfileDto pageMainDto = userService.getMyPage(email);

        return ResponseEntity.ok().body(pageMainDto);
    }
}
