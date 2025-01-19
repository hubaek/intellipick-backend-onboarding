package com.onboading.intellipick.domain.auth.service;

import com.onboading.intellipick.domain.auth.controller.dto.AuthorityDto;
import com.onboading.intellipick.domain.auth.controller.dto.SignupRequest;
import com.onboading.intellipick.domain.auth.controller.dto.SignupResponse;
import com.onboading.intellipick.domain.user.Entity.User;
import com.onboading.intellipick.domain.user.enums.UserRole;
import com.onboading.intellipick.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public SignupResponse register(SignupRequest signupRequest) {

        String password = passwordEncoder.encode(signupRequest.getPassword());

        User user = User.builder().
                username(signupRequest.getUsername()).
                password(password).
                nickname(signupRequest.getNickname()).
                userRole(UserRole.USER).build();

        userRepository.save(user);
        List<AuthorityDto> authorities = List.of(new AuthorityDto(user.getUserRole().getAuthorityName()));
        return new SignupResponse(user.getUsername(), user.getNickname(), authorities);

    }
}
