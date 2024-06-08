package com.deptech.controller;

import com.deptech.constant.Endpoint;
import com.deptech.constant.TipeTransaksi;
import com.deptech.dto.request.TransaksiRequest;
import com.deptech.dto.response.TransaksiResponse;
import com.deptech.service.TransaksiService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Endpoint.TRANSAKSI)
@AllArgsConstructor
public class TransaksiController {

    private final TransaksiService transaksiService;

    @PostMapping
    public TransaksiResponse create(@RequestBody @Valid TransaksiRequest request) {
        return transaksiService.create(request);
    }

    @GetMapping
    public List<TransaksiResponse> list(@RequestParam(required = false) TipeTransaksi tipeTransaksi) {
        return transaksiService.list(tipeTransaksi);
    }
}
