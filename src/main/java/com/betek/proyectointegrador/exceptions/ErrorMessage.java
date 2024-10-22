package com.betek.proyectointegrador.exceptions;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorMessage {
    BAD_REQUEST(400, "Bad Request", "mensaje 1"),
    INTERNAL_ERROR(500, "Internal Error", "mensaje 2");

    private final Integer code;
    private final String title;
    private final String detail;

}
