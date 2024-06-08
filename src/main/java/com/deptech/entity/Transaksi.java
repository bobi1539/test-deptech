package com.deptech.entity;

import com.deptech.constant.TipeTransaksi;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "transaksi")
public class Transaksi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "tipe_transaksi")
    @Enumerated(EnumType.STRING)
    private TipeTransaksi tipeTransaksi;

    @Column(name = "tanggal_transaksi")
    private LocalDateTime tanggalTransaksi;
}
