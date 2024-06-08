package com.deptech.repository;

import com.deptech.entity.Produk;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdukRepository extends JpaRepository<Produk, Long> {
}
