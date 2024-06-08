package com.deptech.service.impl;

import com.deptech.constant.GlobalMessage;
import com.deptech.constant.TipeTransaksi;
import com.deptech.dto.request.TransaksiProdukRequest;
import com.deptech.dto.request.TransaksiRequest;
import com.deptech.dto.response.TransaksiResponse;
import com.deptech.entity.Produk;
import com.deptech.entity.Transaksi;
import com.deptech.entity.TransaksiProduk;
import com.deptech.exception.BusinessException;
import com.deptech.helper.EntityHelper;
import com.deptech.repository.ProdukRepository;
import com.deptech.repository.TransaksiProdukRepository;
import com.deptech.repository.TransaksiRepository;
import com.deptech.service.TransaksiService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class TransaksiServiceImpl implements TransaksiService {

    private final TransaksiRepository transaksiRepository;
    private final TransaksiProdukRepository transaksiProdukRepository;
    private final ProdukRepository produkRepository;

    @Transactional
    @Override
    public TransaksiResponse create(TransaksiRequest request) {
        Transaksi transaksi = Transaksi.builder()
                .tipeTransaksi(request.getTipeTransaksi())
                .tanggalTransaksi(LocalDateTime.now())
                .build();
        transaksi = transaksiRepository.save(transaksi);

        Transaksi finalTransaksi = transaksi;
        List<TransaksiProduk> transaksiProduks = new ArrayList<>();
        request.getTransaksiProduks().forEach(produkRequest -> {
            Produk produk = updateStockProduk(produkRequest, request.getTipeTransaksi());
            TransaksiProduk transaksiProduk = saveTransaksiProduk(finalTransaksi, produk, produkRequest.getJumlahProduk());
            transaksiProduks.add(transaksiProduk);
        });
        return EntityHelper.toTransaksiResponse(finalTransaksi, transaksiProduks);
    }

    @Override
    public List<TransaksiResponse> list(TipeTransaksi tipeTransaksi) {
        Specification<Transaksi> specification = ((root, query, criteriaBuilder) -> {
            if (ObjectUtils.isEmpty(tipeTransaksi)) {
                return null;
            }
            return criteriaBuilder.equal(root.get("tipeTransaksi"), tipeTransaksi);
        });


        List<Transaksi> transaksis = transaksiRepository.findAll(specification);
        return transaksis.stream().map(transaksi -> {
            List<TransaksiProduk> transaksiProduks = transaksiProdukRepository.findByTransaksi(transaksi);
            return EntityHelper.toTransaksiResponse(transaksi, transaksiProduks);
        }).toList();
    }

    private Produk findProdukById(Long id) {
        return produkRepository.findById(id).orElseThrow(
                () -> new BusinessException(GlobalMessage.PRODUK_NOT_EXIST)
        );
    }

    private Produk updateStockProduk(TransaksiProdukRequest produkRequest, TipeTransaksi tipeTransaksi) {
        Produk produk = findProdukById(produkRequest.getProdukId());

        if (tipeTransaksi.equals(TipeTransaksi.STOCK_IN)) {
            produk.setStokProduk(produk.getStokProduk() + produkRequest.getJumlahProduk());
        } else {
            if (produk.getStokProduk() < produkRequest.getJumlahProduk()) {
                throw new BusinessException(GlobalMessage.OUT_OF_STOCK);
            }
            produk.setStokProduk(produk.getStokProduk() - produkRequest.getJumlahProduk());
        }
        return produkRepository.save(produk);
    }

    private TransaksiProduk saveTransaksiProduk(Transaksi transaksi, Produk produk, Integer jumlahProduk) {
        TransaksiProduk transaksiProduk = TransaksiProduk.builder()
                .transaksi(transaksi)
                .produk(produk)
                .jumlahProduk(jumlahProduk)
                .build();
        return transaksiProdukRepository.save(transaksiProduk);
    }
}
