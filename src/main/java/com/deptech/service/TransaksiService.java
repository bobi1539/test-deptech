package com.deptech.service;

import com.deptech.constant.TipeTransaksi;
import com.deptech.dto.request.TransaksiRequest;
import com.deptech.dto.response.TransaksiResponse;

import java.util.List;

public interface TransaksiService {

    TransaksiResponse create(TransaksiRequest request);

    List<TransaksiResponse> list(TipeTransaksi tipeTransaksi);
}
