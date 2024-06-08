package com.deptech.dto.response;

import com.deptech.constant.Gender;
import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class AdminResponse {
    private Long id;
    private String namaDepan;
    private String namaBelakang;
    private String email;
    private Date tanggalLahir;
    private Gender jenisKelamin;
}
