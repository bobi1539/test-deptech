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
public class KategoriProdukRequest {

    @NotNull(message = Constant.NAMA_KATEGORI_REQUIRED)
    @NotEmpty(message = Constant.NAMA_KATEGORI_REQUIRED)
    private String namaKategoriProduk;

    private String deskripsiKategoriProduk;
}
