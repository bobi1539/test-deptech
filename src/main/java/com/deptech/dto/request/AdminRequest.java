package com.deptech.dto.request;

import com.deptech.constant.Constant;
import com.deptech.constant.Gender;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class AdminRequest {

    @NotNull(message = Constant.NAMA_DEPAN_REQUIRED)
    @NotEmpty(message = Constant.NAMA_DEPAN_REQUIRED)
    private String namaDepan;

    @NotNull(message = Constant.NAMA_BELAKANG_REQUIRED)
    @NotEmpty(message = Constant.NAMA_BELAKANG_REQUIRED)
    private String namaBelakang;

    @NotNull(message = Constant.EMAIL_REQUIRED)
    @NotEmpty(message = Constant.EMAIL_REQUIRED)
    private String email;

    @NotNull(message = Constant.TANGGAL_LAHIR_REQUIRED)
    private Date tanggalLahir;
    private Gender jenisKelamin;

    @NotNull(message = Constant.PASSWORD_REQUIRED)
    @NotEmpty(message = Constant.PASSWORD_REQUIRED)
    private String password;
}
