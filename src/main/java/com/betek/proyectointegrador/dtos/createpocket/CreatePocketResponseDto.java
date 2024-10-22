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
public class CreatePocketResponseDto {

    @JsonProperty("account_number")
    private String accountNumber;
    @JsonProperty("pocket_number")
    private String pocketNumber;
    @JsonProperty("initial_balance")
    private Double initialBalance;

}
