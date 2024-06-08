package com.deptech.dto.response;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class KategoriProdukResponse {
    private Long id;
    private String namaKategoriProduk;
    private String deskripsiKategoriProduk;
}
