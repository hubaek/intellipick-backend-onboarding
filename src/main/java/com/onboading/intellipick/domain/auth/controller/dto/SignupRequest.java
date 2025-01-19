package com.onboading.intellipick.domain.auth.controller.dto;

import lombok.Getter;

@Getter
public class SignupRequest {
    private String username;
    private String password;
    private String nickname;
}
