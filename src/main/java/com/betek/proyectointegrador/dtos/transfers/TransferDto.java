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
public class TransferDto {

    @JsonProperty("source_account_number")
    private String sourceAccountNumber;
    @JsonProperty("destination_account_number")
    private String destinationAccountNumber;
    @JsonProperty("amount")
    private Double amount;
}
