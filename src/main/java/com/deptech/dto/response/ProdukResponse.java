package com.deptech.dto.response;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ProdukResponse {
    private Long id;
    private String namaProduk;
    private String deskripsiProduk;
    private String gambarProduk;
    private KategoriProdukResponse kategoriProduk;
    private Integer stokProduk;
}
