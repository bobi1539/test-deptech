package com.deptech.constant;

import com.deptech.exception.BusinessException;

public final class Constant {

    private Constant() {
        throw new BusinessException(GlobalMessage.CANNOT_INSTANCE_HELPER_CLASS);
    }

    public static final String ERROR = "Error : ";
    public static final String SUCCESS = "Success";
    public static final String INTERNAL_SERVER_ERROR = "Internal server error";
    public static final String PRODUK_NOT_EXIST = "Produk Tidak Tersedia";
    public static final String KATEGORI_PRODUK_NOT_EXIST = "Kategori Produk Tidak Tersedia";
    public static final String ADMIN_NOT_EXIST = "Admin Tidak Tersedia";
    public static final String NAMA_KATEGORI_REQUIRED = "Nama Kategori Produk Tidak Boleh Kosong";
    public static final String NAMA_PRODUK_REQUIRED = "Nama Produk Tidak Boleh Kosong";
    public static final String STOK_PRODUK_REQUIRED = "Stok Produk Tidak Boleh Kosong";
    public static final String EMAIL_ALREADY_EXIST = "Email Telah Terdaftar";
    public static final String WRONG_EMAIL_OR_PASSWORD = "Email Atau Password Salah";
    public static final String LOGIN_ID_NOT_VALID = "Login Id Tidak Valid";
    public static final String ALREADY_LOGIN = "Email Tersebut Telah Login";
    public static final String NAMA_DEPAN_REQUIRED = "Nama Depan Tidak Boleh Kosong";
    public static final String NAMA_BELAKANG_REQUIRED = "Nama Belakang Tidak Boleh Kosong";
    public static final String EMAIL_REQUIRED = "Email Tidak Boleh Kosong";
    public static final String TANGGAL_LAHIR_REQUIRED = "Tanggal Lahir Tidak Boleh Kosong";
    public static final String PASSWORD_REQUIRED = "Password Tidak Boleh Kosong";
}
