package com.deptech.service;

import com.deptech.dto.request.ProdukRequest;
import com.deptech.dto.response.ProdukResponse;

import java.util.List;

public interface ProdukService {

    ProdukResponse create(ProdukRequest request);

    ProdukResponse update(Long id, ProdukRequest request);

    void delete(Long id);

    ProdukResponse read(Long id);

    List<ProdukResponse> list();
}
