package com.deptech.service.impl;

import com.deptech.constant.GlobalMessage;
import com.deptech.dto.request.KategoriProdukRequest;
import com.deptech.dto.response.KategoriProdukResponse;
import com.deptech.entity.KategoriProduk;
import com.deptech.exception.BusinessException;
import com.deptech.helper.EntityHelper;
import com.deptech.repository.KategoriProdukRepository;
import com.deptech.service.KategoriProdukService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class KategoriProdukServiceImpl implements KategoriProdukService {

    private final KategoriProdukRepository kategoriProdukRepository;

    @Override
    public KategoriProdukResponse create(KategoriProdukRequest request) {
        KategoriProduk kategoriProduk = EntityHelper.toKategoriProduk(request);
        kategoriProduk = kategoriProdukRepository.save(kategoriProduk);
        return EntityHelper.toKategoriProdukResponse(kategoriProduk);
    }

    @Override
    public KategoriProdukResponse update(Long id, KategoriProdukRequest request) {
        KategoriProduk kategoriProduk = findKategoriProdukById(id);
        kategoriProduk.setNamaKategoriProduk(request.getNamaKategoriProduk());
        kategoriProduk.setDeskripsiKategoriProduk(request.getDeskripsiKategoriProduk());
        kategoriProduk = kategoriProdukRepository.save(kategoriProduk);
        return EntityHelper.toKategoriProdukResponse(kategoriProduk);
    }

    @Override
    public void delete(Long id) {
        KategoriProduk kategoriProduk = findKategoriProdukById(id);
        kategoriProdukRepository.delete(kategoriProduk);
    }

    @Override
    public KategoriProdukResponse read(Long id) {
        KategoriProduk kategoriProduk = findKategoriProdukById(id);
        return EntityHelper.toKategoriProdukResponse(kategoriProduk);
    }

    @Override
    public List<KategoriProdukResponse> list() {
        List<KategoriProduk> kategoriProduks = kategoriProdukRepository.findAll();
        return kategoriProduks.stream().map(
                kategoriProduk -> KategoriProdukResponse.builder()
                        .id(kategoriProduk.getId())
                        .namaKategoriProduk(kategoriProduk.getNamaKategoriProduk())
                        .deskripsiKategoriProduk(kategoriProduk.getDeskripsiKategoriProduk())
                        .build()
        ).toList();
    }

    private KategoriProduk findKategoriProdukById(Long id) {
        return kategoriProdukRepository.findById(id).orElseThrow(
                () -> new BusinessException(GlobalMessage.KATEGORI_PRODUK_NOT_EXIST)
        );
    }
}
