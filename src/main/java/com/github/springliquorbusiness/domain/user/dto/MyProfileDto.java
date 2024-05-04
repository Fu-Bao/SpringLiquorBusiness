package com.github.springliquorbusiness.domain.user.dto;

import com.github.springliquorbusiness.domain.user.entity.UserEntity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MyProfileDto {

    private String profile_img;

//    @NotBlank(message = "닉네임은 필수 입력 값입니다.")
//    @Pattern(regexp = "^[a-zA-Z0-9가-힣\\s]{1,10}$", message = "닉네임은 특수문자를 제외한 4~8글자여야 합니다.")
    private String username;

//    @Pattern(regexp = "^[\\s\\S]{0,100}$", message = "소개글은 공백 포함 100자여야 합니다.")
    private String description;

    public static MyProfileDto toMyPageMainDto(UserEntity user) {
        return MyProfileDto.builder()
                .profile_img(user.getProfileImg())
                .username(user.getUsername())
                .description(user.getDescription())
                .build();
    }
}
