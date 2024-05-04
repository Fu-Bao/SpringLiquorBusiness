package com.github.springliquorbusiness.domain.auth.service;

import com.github.springliquorbusiness.domain.auth.entity.CustomUserDetails;
import com.github.springliquorbusiness.domain.user.entity.UserEntity;
import com.github.springliquorbusiness.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException());

        return new CustomUserDetails(user);
    }
}
