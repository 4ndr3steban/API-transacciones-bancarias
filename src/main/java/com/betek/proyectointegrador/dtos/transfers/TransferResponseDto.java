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
public class TransferResponseDto {

    @JsonProperty("transfer_result")
    private String transferResult;

}
