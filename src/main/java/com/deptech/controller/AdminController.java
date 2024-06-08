package com.deptech.controller;

import com.deptech.constant.Endpoint;
import com.deptech.dto.request.AdminRequest;
import com.deptech.dto.response.AdminResponse;
import com.deptech.service.AdminService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Endpoint.ADMIN)
@AllArgsConstructor
public class AdminController {

    private final AdminService adminService;

    @PostMapping
    public AdminResponse create(@RequestBody @Valid AdminRequest request) {
        return adminService.create(request);
    }

    @PutMapping("/{id}")
    public AdminResponse update(
            @PathVariable Long id,
            @RequestBody @Valid AdminRequest request
    ) {
        return adminService.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        adminService.delete(id);
    }

    @GetMapping("/{id}")
    public AdminResponse read(@PathVariable Long id) {
        return adminService.read(id);
    }

    @GetMapping
    public List<AdminResponse> list() {
        return adminService.list();
    }
}
