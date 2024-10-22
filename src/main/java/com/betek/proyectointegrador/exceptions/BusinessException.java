package com.betek.proyectointegrador.exceptions;

import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException{

    private final String title;
    private final Integer code;
    private final String detail;

    public BusinessException(ErrorMessage ErrorMessage) {
        super(ErrorMessage.getDetail());
        this.title = ErrorMessage.getTitle();
        this.code = ErrorMessage.getCode();
        this.detail = ErrorMessage.getDetail();
    }
}
