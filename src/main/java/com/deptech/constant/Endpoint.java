package com.deptech.constant;

import com.deptech.exception.BusinessException;

public final class Endpoint {

    private Endpoint() {
        throw new BusinessException(GlobalMessage.CANNOT_INSTANCE_HELPER_CLASS);
    }

    public static final String BASE = "/api/test-deptech";
    public static final String KATEGORI_PRODUK = BASE + "/kategories-produk";
    public static final String INVENTORY = BASE + "/inventories";
    public static final String ORDER = BASE + "/orders";
}
