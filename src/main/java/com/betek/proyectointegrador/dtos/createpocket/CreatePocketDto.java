package com.betek.proyectointegrador.dtos.createpocket;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class CreatePocketDto {

    @JsonProperty("account_number")
    private String accountNumber;
    @JsonProperty("name")
    private String name;
    @JsonProperty("initial_balance")
    private Double initialBalance;
}
