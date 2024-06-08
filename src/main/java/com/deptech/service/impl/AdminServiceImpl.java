package com.deptech.service.impl;

import com.deptech.constant.GlobalMessage;
import com.deptech.dto.request.AdminRequest;
import com.deptech.dto.response.AdminResponse;
import com.deptech.entity.Admin;
import com.deptech.exception.BusinessException;
import com.deptech.helper.EntityHelper;
import com.deptech.repository.AdminRepository;
import com.deptech.service.AdminService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AdminServiceImpl implements AdminService {

    private final AdminRepository adminRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public AdminResponse create(AdminRequest request) {
        validateEmail(request.getEmail());

        Admin admin = EntityHelper.toAdmin(request);
        admin.setPassword(hashPassword(request.getPassword()));
        admin = adminRepository.save(admin);
        return EntityHelper.toAdminResponse(admin);
    }

    @Override
    public AdminResponse update(Long id, AdminRequest request) {
        Admin admin = findAdminById(id);
        if (!admin.getEmail().equals(request.getEmail())) {
            validateEmail(request.getEmail());
        }

        admin.setNamaDepan(request.getNamaDepan());
        admin.setNamaBelakang(request.getNamaBelakang());
        admin.setEmail(request.getEmail());
        admin.setTanggalLahir(request.getTanggalLahir());
        admin.setJenisKelamin(request.getJenisKelamin());
        admin.setPassword(hashPassword(request.getPassword()));
        admin = adminRepository.save(admin);
        return EntityHelper.toAdminResponse(admin);
    }

    @Override
    public void delete(Long id) {
        Admin admin = findAdminById(id);
        adminRepository.delete(admin);
    }

    @Override
    public AdminResponse read(Long id) {
        return EntityHelper.toAdminResponse(findAdminById(id));
    }

    @Override
    public List<AdminResponse> list() {
        List<Admin> admins = adminRepository.findAll();
        return admins.stream().map(EntityHelper::toAdminResponse).toList();
    }

    private String hashPassword(String password) {
        return passwordEncoder.encode(password);
    }

    private Admin findAdminById(Long id) {
        return adminRepository.findById(id).orElseThrow(
                () -> new BusinessException(GlobalMessage.ADMIN_NOT_EXIST)
        );
    }

    private void validateEmail(String email) {
        Optional<Admin> admin = adminRepository.findByEmail(email);
        if (admin.isPresent()) {
            throw new BusinessException(GlobalMessage.EMAIL_ALREADY_EXIST);
        }
    }
}
