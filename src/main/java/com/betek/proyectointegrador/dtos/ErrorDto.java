package com.betek.proyectointegrador.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class ErrorDto {

    @JsonProperty("code")
    private Integer code;
    @JsonProperty("title")
    private String title;
    @JsonProperty("detail")
    private String detail;
}
