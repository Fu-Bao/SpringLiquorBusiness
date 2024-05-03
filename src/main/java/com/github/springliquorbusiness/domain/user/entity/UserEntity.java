package com.github.springliquorbusiness.domain.user.entity;

import com.github.springliquorbusiness.domain.user.dto.SignupDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Builder
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

    public static UserEntity SignupToEntity(SignupDto signupDto) {
        return UserEntity.builder()
                .email(signupDto.getEmail())
                .username(signupDto.getUsername())
                .password(signupDto.getPassword())
                .build();
    }
}
