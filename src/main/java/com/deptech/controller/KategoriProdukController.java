package com.deptech.controller;

import com.deptech.constant.Endpoint;
import com.deptech.dto.request.KategoriProdukRequest;
import com.deptech.dto.response.KategoriProdukResponse;
import com.deptech.service.KategoriProdukService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Endpoint.KATEGORI_PRODUK)
@AllArgsConstructor
public class KategoriProdukController {

    private final KategoriProdukService kategoriProdukService;

    @PostMapping
    public KategoriProdukResponse create(@RequestBody @Valid KategoriProdukRequest request) {
        return kategoriProdukService.create(request);
    }

    @PutMapping("/{id}")
    public KategoriProdukResponse update(
            @PathVariable Long id,
            @RequestBody @Valid KategoriProdukRequest request
    ) {
        return kategoriProdukService.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        kategoriProdukService.delete(id);
    }

    @GetMapping("/{id}")
    public KategoriProdukResponse read(@PathVariable Long id) {
        return kategoriProdukService.read(id);
    }

    @GetMapping
    public List<KategoriProdukResponse> list() {
        return kategoriProdukService.list();
    }
}
