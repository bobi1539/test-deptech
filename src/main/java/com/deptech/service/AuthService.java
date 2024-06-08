package com.deptech.service;

import com.deptech.dto.request.LoginRequest;
import com.deptech.dto.response.LoginResponse;

public interface AuthService {

    LoginResponse login(LoginRequest request);

    void logout(Long loginId);
}
