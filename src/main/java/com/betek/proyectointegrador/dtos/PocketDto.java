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
public class PocketDto {

    @JsonProperty("name")
    private String name;
    @JsonProperty("pocket_number")
    private String pocketNumber;
    @JsonProperty("amount")
    private Double amount;
}