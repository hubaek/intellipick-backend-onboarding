package com.onboading.intellipick.domain.auth.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class SignupResponse {

    private String username;
    private String nickname;
    private List<AuthorityDto> authorities;
}
