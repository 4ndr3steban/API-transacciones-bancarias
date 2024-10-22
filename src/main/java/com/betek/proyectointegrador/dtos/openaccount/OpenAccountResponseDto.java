package com.betek.proyectointegrador.dtos.openaccount;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class OpenAccountResponseDto {

    @JsonProperty("account_number")
    private String accountNumber;
    @JsonProperty("owner_id")
    private Integer ownerId;
    @JsonProperty("initial_balance")
    private Double initialBalance;
}
