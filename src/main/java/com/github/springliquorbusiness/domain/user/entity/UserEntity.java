package com.github.springliquorbusiness.domain.user.entity;

import com.github.springliquorbusiness.domain.address.entity.AddressEntity;
import com.github.springliquorbusiness.domain.user.dto.SignupDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "users")
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

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AddressEntity> addresses = new ArrayList<>();

    // 비밀번호 암호화
    public void passwordEncode(PasswordEncoder passwordEncoder) {
        this.password = passwordEncoder.encode(this.password);
    }

    // 여러 배송지들 중에서 하나만 기본 배송지 설정
    public void setDefaultAddress(AddressEntity defaultAddress) {
        for (AddressEntity address : addresses) {
            address.setIsDefault(address.equals(defaultAddress));
        }
    }

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
