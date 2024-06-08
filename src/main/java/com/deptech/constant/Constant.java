package com.deptech.constant;

import com.deptech.exception.BusinessException;

public final class Constant {

    private Constant() {
        throw new BusinessException(GlobalMessage.CANNOT_INSTANCE_HELPER_CLASS);
    }

    public static final String ERROR = "Error : ";
    public static final String SUCCESS = "Success";
    public static final String INTERNAL_SERVER_ERROR = "Internal server error";
    public static final String NAME_REQUIRED = "Name is required";
    public static final String PRICE_REQUIRED = "Price is required";
    public static final String ITEM_NOT_EXIST = "Item not exist";
    public static final String KATEGORI_PRODUK_NOT_EXIST = "Kategori Produk Tidak Tersedia";
    public static final String ORDER_NOT_EXIST = "Order not exist";
    public static final String NAMA_KATEGORI_REQUIRED = "Nama Kategori Produk Tidak Boleh Kosong";
    public static final String QUANTITY_REQUIRED = "Quantity is required";
    public static final String INVENTORY_TYPE_REQUIRED = "Type is required";
    public static final String ITEM_STOCK_INSUFFICIENT = "Item stock is insufficient";
    public static final String ITEM_CANNOT_DELETE = "Item cannot be delete";
}
