package com.deptech.service.impl;

import com.deptech.constant.GlobalMessage;
import com.deptech.dto.request.LoginRequest;
import com.deptech.dto.response.LoginResponse;
import com.deptech.entity.Admin;
import com.deptech.entity.Login;
import com.deptech.exception.BusinessException;
import com.deptech.helper.EntityHelper;
import com.deptech.repository.AdminRepository;
import com.deptech.repository.LoginRepository;
import com.deptech.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final LoginRepository loginRepository;
    private final AdminRepository adminRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public LoginResponse login(LoginRequest request) {
        validateLogin(request.getEmail());
        Admin admin = findAdminByEmail(request.getEmail());
        validatePassword(request.getPassword(), admin.getPassword());

        Login login = EntityHelper.toLogin(admin);
        login = loginRepository.save(login);
        return EntityHelper.toLoginResponse(login);
    }

    @Override
    public void logout(Long loginId) {
        Login login = findLoginById(loginId);
        loginRepository.delete(login);
    }

    private Admin findAdminByEmail(String email) {
        return adminRepository.findByEmail(email).orElseThrow(
                () -> new BusinessException(GlobalMessage.WRONG_EMAIL_OR_PASSWORD)
        );
    }

    private void validatePassword(String password, String hashPassword) {
        if (!passwordEncoder.matches(password, hashPassword)) {
            throw new BusinessException(GlobalMessage.WRONG_EMAIL_OR_PASSWORD);
        }
    }

    private Login findLoginById(Long loginId) {
        return loginRepository.findById(loginId).orElseThrow(
                () -> new BusinessException(GlobalMessage.LOGIN_ID_NOT_VALID)
        );
    }

    private void validateLogin(String email) {
        Optional<Login> login = loginRepository.findByEmail(email);
        if (login.isPresent()) {
            throw new BusinessException(GlobalMessage.ALREADY_LOGIN);
        }
    }
}
