package com.deptech.dto.response;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class TransaksiProdukResponse {
    private Long id;
    private ProdukResponse produk;
    private Integer jumlahProduk;
}
