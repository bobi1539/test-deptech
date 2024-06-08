package com.deptech.controller;

import com.deptech.constant.Endpoint;
import com.deptech.dto.request.LoginRequest;
import com.deptech.dto.response.LoginResponse;
import com.deptech.service.AuthService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(Endpoint.AUTH)
@AllArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public LoginResponse login(@RequestBody @Valid LoginRequest request) {
        return authService.login(request);
    }

    @DeleteMapping("/logout/{loginId}")
    public void logout(@PathVariable Long loginId) {
        authService.logout(loginId);
    }
}
