package com.deptech.service.impl;

import com.deptech.constant.GlobalMessage;
import com.deptech.dto.request.ProdukRequest;
import com.deptech.dto.response.ProdukResponse;
import com.deptech.entity.KategoriProduk;
import com.deptech.entity.Produk;
import com.deptech.exception.BusinessException;
import com.deptech.helper.EntityHelper;
import com.deptech.repository.KategoriProdukRepository;
import com.deptech.repository.ProdukRepository;
import com.deptech.service.ProdukService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProdukServiceImpl implements ProdukService {

    private final ProdukRepository produkRepository;
    private final KategoriProdukRepository kategoriProdukRepository;

    @Override
    public ProdukResponse create(ProdukRequest request) {
        KategoriProduk kategoriProduk = findKategoriProdukById(request.getKategoriProdukId());
        Produk produk = EntityHelper.toProduk(request, kategoriProduk);
        produk = produkRepository.save(produk);
        return EntityHelper.toProdukResponse(produk);
    }

    @Override
    public ProdukResponse update(Long id, ProdukRequest request) {
        KategoriProduk kategoriProduk = findKategoriProdukById(request.getKategoriProdukId());
        Produk produk = findProdukById(id);
        produk.setNamaProduk(request.getNamaProduk());
        produk.setDeskripsiProduk(request.getDeskripsiProduk());
        produk.setGambarProduk(request.getGambarProduk());
        produk.setKategoriProduk(kategoriProduk);
        produk.setStokProduk(request.getStokProduk());

        produk = produkRepository.save(produk);
        return EntityHelper.toProdukResponse(produk);
    }

    @Override
    public void delete(Long id) {
        Produk produk = findProdukById(id);
        produkRepository.delete(produk);
    }

    @Override
    public ProdukResponse read(Long id) {
        Produk produk = findProdukById(id);
        return EntityHelper.toProdukResponse(produk);
    }

    @Override
    public List<ProdukResponse> list() {
        List<Produk> produks = produkRepository.findAll();
        return produks.stream().map(EntityHelper::toProdukResponse).toList();
    }

    private KategoriProduk findKategoriProdukById(Long id) {
        return kategoriProdukRepository.findById(id).orElseThrow(
                () -> new BusinessException(GlobalMessage.KATEGORI_PRODUK_NOT_EXIST)
        );
    }

    private Produk findProdukById(Long id) {
        return produkRepository.findById(id).orElseThrow(
                () -> new BusinessException(GlobalMessage.PRODUK_NOT_EXIST)
        );
    }
}
