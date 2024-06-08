package com.deptech.controller;

import com.deptech.constant.Endpoint;
import com.deptech.dto.request.ProdukRequest;
import com.deptech.dto.response.ProdukResponse;
import com.deptech.service.ProdukService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Endpoint.PRODUK)
@AllArgsConstructor
public class ProdukController {

    private final ProdukService produkService;

    @PostMapping
    public ProdukResponse create(@RequestBody @Valid ProdukRequest request) {
        return produkService.create(request);
    }

    @PutMapping("/{id}")
    public ProdukResponse update(
            @PathVariable Long id,
            @RequestBody @Valid ProdukRequest request
    ) {
        return produkService.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        produkService.delete(id);
    }

    @GetMapping("/{id}")
    public ProdukResponse read(@PathVariable Long id) {
        return produkService.read(id);
    }

    @GetMapping
    public List<ProdukResponse> list() {
        return produkService.list();
    }
}
