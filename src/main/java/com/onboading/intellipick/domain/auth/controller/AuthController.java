package com.onboading.intellipick.domain.auth.controller;


import com.onboading.intellipick.domain.auth.controller.dto.SignupRequest;
import com.onboading.intellipick.domain.auth.controller.dto.SignupResponse;
import com.onboading.intellipick.domain.auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<SignupResponse> signup(@RequestBody SignupRequest signupRequest) {
        SignupResponse signupResponse = authService.register(signupRequest);
        return ResponseEntity.ok(signupResponse);
    }

}
