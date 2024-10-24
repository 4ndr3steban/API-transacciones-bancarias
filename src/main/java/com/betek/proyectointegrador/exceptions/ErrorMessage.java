package com.betek.proyectointegrador.exceptions;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorMessage {
    PRODUCT_NOT_FOUND(400, "Bad Request", "Account o pocket not founded"),
    PARAMETER_NOT_FOUND(400, "Bad Request", "Needed parameter not found"),
    USER_NOT_FOUND(400, "Bad Request", "User id not founded"),
    USER_ALREADY_EXIST(400, "Bad Request", "User already exist"),
    INTERNAL_ERROR(500, "Internal Error", "System internal error");

    private final Integer code;
    private final String title;
    private final String detail;

}
