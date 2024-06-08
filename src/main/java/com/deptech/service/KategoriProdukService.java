package com.deptech.service;

import com.deptech.dto.request.KategoriProdukRequest;
import com.deptech.dto.response.KategoriProdukResponse;

import java.util.List;

public interface KategoriProdukService {

    KategoriProdukResponse create(KategoriProdukRequest request);

    KategoriProdukResponse update(Long id, KategoriProdukRequest request);

    void delete(Long id);

    KategoriProdukResponse read(Long id);

    List<KategoriProdukResponse> list();
}
