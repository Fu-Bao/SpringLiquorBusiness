package com.github.springliquorbusiness.domain.user.entity;

import com.github.springliquorbusiness.domain.user.dto.SignupDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idx")
    private Long idx;

    @Column(name = "email")
    private String email;

    @Column(name = "username", unique = true)
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "profile_img")
    private String profileImg;

    private String description;

    @Column(name = "refresh_token")
    private String refreshToken;

    public void initRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public static UserEntity SignupToEntity(SignupDto signupDto) {
        return UserEntity.builder()
                .email(signupDto.getEmail())
                .username(signupDto.getUsername())
                .password(signupDto.getPassword())
                .profileImg(null)
                .build();
    }
}
