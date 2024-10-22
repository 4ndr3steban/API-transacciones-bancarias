package com.betek.proyectointegrador.exceptions;

import com.betek.proyectointegrador.dtos.ErrorDto;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.bind.annotation.ExceptionHandler;

@RestControllerAdvice
public class ServiceExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<ErrorDto> clienteRequestException(BusinessException ex){
        ErrorDto errorDto = ErrorDto.builder()
                .code(ex.getCode())
                .title(ex.getTitle())
                .detail(ex.getDetail())
                .build();
        return new ResponseEntity<ErrorDto>(errorDto, HttpStatusCode.valueOf(ex.getCode()));
    }
}
