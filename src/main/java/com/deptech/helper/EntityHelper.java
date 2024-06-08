package com.deptech.helper;

import com.deptech.constant.GlobalMessage;
import com.deptech.dto.request.KategoriProdukRequest;
import com.deptech.dto.response.KategoriProdukResponse;
import com.deptech.entity.KategoriProduk;
import com.deptech.exception.BusinessException;

public final class EntityHelper {

    private EntityHelper() {
        throw new BusinessException(GlobalMessage.CANNOT_INSTANCE_HELPER_CLASS);
    }

    public static KategoriProduk toKategoriProduk(KategoriProdukRequest request) {
        return KategoriProduk.builder()
                .namaKategoriProduk(request.getNamaKategoriProduk())
                .deskripsiKategoriProduk(request.getDeskripsiKategoriProduk())
                .build();
    }

    public static KategoriProdukResponse toKategoriProdukResponse(KategoriProduk kategoriProduk) {
        return KategoriProdukResponse.builder()
                .id(kategoriProduk.getId())
                .namaKategoriProduk(kategoriProduk.getNamaKategoriProduk())
                .deskripsiKategoriProduk(kategoriProduk.getDeskripsiKategoriProduk())
                .build();
    }
}
