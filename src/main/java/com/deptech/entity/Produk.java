package com.deptech.entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "produk")
public class Produk {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nama_produk")
    private String namaProduk;

    @Column(name = "deskripsi_produk")
    private String deskripsiProduk;

    @Column(name = "gambar_produk")
    private String gambarProduk;

    @ManyToOne
    @JoinColumn(name = "kategori_produk_id")
    private KategoriProduk kategoriProduk;

    @Column(name = "stok_produk")
    private Integer stokProduk;
}
