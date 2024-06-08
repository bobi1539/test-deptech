package com.deptech.helper;

import com.deptech.constant.GlobalMessage;
import com.deptech.dto.request.AdminRequest;
import com.deptech.dto.request.KategoriProdukRequest;
import com.deptech.dto.request.ProdukRequest;
import com.deptech.dto.response.AdminResponse;
import com.deptech.dto.response.KategoriProdukResponse;
import com.deptech.dto.response.LoginResponse;
import com.deptech.dto.response.ProdukResponse;
import com.deptech.entity.Admin;
import com.deptech.entity.KategoriProduk;
import com.deptech.entity.Login;
import com.deptech.entity.Produk;
import com.deptech.exception.BusinessException;

import java.time.LocalDateTime;

public final class EntityHelper {

    private EntityHelper() {
        throw new BusinessException(GlobalMessage.CANNOT_INSTANCE_HELPER_CLASS);
    }

    public static KategoriProduk toKategoriProduk(KategoriProdukRequest request) {
        return KategoriProduk.builder()
                .namaKategoriProduk(request.getNamaKategoriProduk())
                .deskripsiKategoriProduk(request.getDeskripsiKategoriProduk())
                .build();
    }

    public static KategoriProdukResponse toKategoriProdukResponse(KategoriProduk kategoriProduk) {
        return KategoriProdukResponse.builder()
                .id(kategoriProduk.getId())
                .namaKategoriProduk(kategoriProduk.getNamaKategoriProduk())
                .deskripsiKategoriProduk(kategoriProduk.getDeskripsiKategoriProduk())
                .build();
    }

    public static Produk toProduk(ProdukRequest request, KategoriProduk kategoriProduk) {
        return Produk.builder()
                .namaProduk(request.getNamaProduk())
                .deskripsiProduk(request.getDeskripsiProduk())
                .gambarProduk(request.getGambarProduk())
                .kategoriProduk(kategoriProduk)
                .stokProduk(request.getStokProduk())
                .build();
    }

    public static ProdukResponse toProdukResponse(Produk produk) {
        return ProdukResponse.builder()
                .id(produk.getId())
                .namaProduk(produk.getNamaProduk())
                .deskripsiProduk(produk.getDeskripsiProduk())
                .gambarProduk(produk.getGambarProduk())
                .kategoriProduk(toKategoriProdukResponse(produk.getKategoriProduk()))
                .stokProduk(produk.getStokProduk())
                .build();
    }

    public static Admin toAdmin(AdminRequest request) {
        return Admin.builder()
                .namaDepan(request.getNamaDepan())
                .namaBelakang(request.getNamaBelakang())
                .email(request.getEmail())
                .tanggalLahir(request.getTanggalLahir())
                .jenisKelamin(request.getJenisKelamin())
                .build();
    }

    public static AdminResponse toAdminResponse(Admin admin) {
        return AdminResponse.builder()
                .id(admin.getId())
                .namaDepan(admin.getNamaDepan())
                .namaBelakang(admin.getNamaBelakang())
                .email(admin.getEmail())
                .tanggalLahir(admin.getTanggalLahir())
                .jenisKelamin(admin.getJenisKelamin())
                .build();
    }

    public static Login toLogin(Admin admin) {
        return Login.builder()
                .admin(admin)
                .email(admin.getEmail())
                .loginTime(LocalDateTime.now())
                .build();
    }

    public static LoginResponse toLoginResponse(Login login) {
        return LoginResponse.builder()
                .id(login.getId())
                .admin(toAdminResponse(login.getAdmin()))
                .loginTime(login.getLoginTime())
                .build();
    }
}
