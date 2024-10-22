package com.betek.proyectointegrador.dtos.transfers;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class PocketTransferResponseDto {

    @JsonProperty("account_number")
    private String accountNumber;
    @JsonProperty("pocket_number")
    private String pocketNumber;
    @JsonProperty("new_amount")
    private Double newAmount;

}
