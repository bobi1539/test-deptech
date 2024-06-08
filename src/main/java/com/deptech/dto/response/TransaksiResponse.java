package com.deptech.dto.response;


import com.deptech.constant.TipeTransaksi;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class TransaksiResponse {
    private Long id;
    private TipeTransaksi tipeTransaksi;
    private LocalDateTime tanggalTransaksi;
    private List<TransaksiProdukResponse> transaksiProduks;
}
