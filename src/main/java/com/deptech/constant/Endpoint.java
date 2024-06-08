package com.deptech.constant;

import com.deptech.exception.BusinessException;

public final class Endpoint {

    private Endpoint() {
        throw new BusinessException(GlobalMessage.CANNOT_INSTANCE_HELPER_CLASS);
    }

    public static final String BASE = "/api/test-deptech";
    public static final String KATEGORI_PRODUK = BASE + "/kategories-produk";
    public static final String PRODUK = BASE + "/produks";
    public static final String ADMIN = BASE + "/admins";
    public static final String AUTH = BASE + "/auths";
    public static final String TRANSAKSI = BASE + "/transaksi";
}
