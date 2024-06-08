package com.deptech.dto.request;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ProdukRequest {
    private String namaProduk;
    private String deskripsiProduk;
    private String gambarProduk;
    private Long kategoriProdukId;
    private Integer stokProduk;
}
