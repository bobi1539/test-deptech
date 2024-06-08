package com.deptech.dto.request;

import com.deptech.constant.TipeTransaksi;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class TransaksiRequest {

    private TipeTransaksi tipeTransaksi;
    private List<TransaksiProdukRequest> transaksiProduks;
}
