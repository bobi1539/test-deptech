package com.deptech.service;

import com.deptech.dto.request.AdminRequest;
import com.deptech.dto.response.AdminResponse;

import java.util.List;

public interface AdminService {

    AdminResponse create(AdminRequest request);

    AdminResponse update(Long id, AdminRequest request);

    void delete(Long id);

    AdminResponse read(Long id);

    List<AdminResponse> list();
}
