package com.deptech.entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "kategori_produk")
public class KategoriProduk {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nama_kategori_produk")
    private String namaKategoriProduk;

    @Column(name = "deskripsi_kategori_produk")
    private String deskripsiKategoriProduk;
}
