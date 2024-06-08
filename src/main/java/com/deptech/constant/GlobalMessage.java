package com.deptech.constant;

import org.springframework.http.HttpStatus;

public enum GlobalMessage {
    SUCCESS(HttpStatus.OK, Constant.SUCCESS),
    PRODUK_NOT_EXIST(HttpStatus.BAD_REQUEST, Constant.PRODUK_NOT_EXIST),
    KATEGORI_PRODUK_NOT_EXIST(HttpStatus.BAD_REQUEST, Constant.KATEGORI_PRODUK_NOT_EXIST),
    ADMIN_NOT_EXIST(HttpStatus.BAD_REQUEST, Constant.ADMIN_NOT_EXIST),
    EMAIL_ALREADY_EXIST(HttpStatus.BAD_REQUEST, Constant.EMAIL_ALREADY_EXIST),
    WRONG_EMAIL_OR_PASSWORD(HttpStatus.BAD_REQUEST, Constant.WRONG_EMAIL_OR_PASSWORD),
    LOGIN_ID_NOT_VALID(HttpStatus.BAD_REQUEST, Constant.LOGIN_ID_NOT_VALID),
    ALREADY_LOGIN(HttpStatus.BAD_REQUEST, Constant.ALREADY_LOGIN),
    CANNOT_INSTANCE_HELPER_CLASS(HttpStatus.INTERNAL_SERVER_ERROR, Constant.INTERNAL_SERVER_ERROR),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, Constant.INTERNAL_SERVER_ERROR);
    public final HttpStatus httpStatus;
    public final String message;

    GlobalMessage(org.springframework.http.HttpStatus httpStatus, String message) {
        this.httpStatus = httpStatus;
        this.message = message;
    }
}
