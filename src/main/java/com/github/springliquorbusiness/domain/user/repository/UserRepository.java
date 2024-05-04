package com.github.springliquorbusiness.domain.user.repository;

import com.github.springliquorbusiness.domain.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

    Optional<UserEntity> findByEmail(String userId);

    Optional<UserEntity> findByRefreshToken(String refreshToken);
}
