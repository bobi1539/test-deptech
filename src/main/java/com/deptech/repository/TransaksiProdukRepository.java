package com.deptech.repository;

import com.deptech.entity.Transaksi;
import com.deptech.entity.TransaksiProduk;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransaksiProdukRepository extends JpaRepository<TransaksiProduk, Long> {

    List<TransaksiProduk> findByTransaksi(Transaksi transaksi);
}
