package com.deptech.dto.request;

import com.deptech.constant.Constant;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class TransaksiProdukRequest {

    @NotNull(message = Constant.PRODUK_ID_REQUIRED)
    private Long produkId;

    @NotNull(message = Constant.JUMLAH_PRODUK_REQUIRED)
    private Integer jumlahProduk;
}
