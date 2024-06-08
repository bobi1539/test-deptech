package com.deptech.repository;

import com.deptech.entity.Transaksi;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransaksiRepository extends JpaRepository<Transaksi, Long> {

    List<Transaksi> findAll(Specification<Transaksi> specification);
}
