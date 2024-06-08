package com.deptech.dto.request;

import com.deptech.constant.Constant;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ProdukRequest {

    @NotNull(message = Constant.NAMA_PRODUK_REQUIRED)
    @NotEmpty(message = Constant.NAMA_PRODUK_REQUIRED)
    private String namaProduk;

    private String deskripsiProduk;
    private String gambarProduk;
    private Long kategoriProdukId;

    @NotNull(message = Constant.STOK_PRODUK_REQUIRED)
    private Integer stokProduk;
}
