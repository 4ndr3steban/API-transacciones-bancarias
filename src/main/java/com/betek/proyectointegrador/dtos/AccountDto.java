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
public class AccountDto {
    @JsonProperty("account_number")
    private String accountNumber;
    @JsonProperty("owner")
    private UserDto owner;
    @JsonProperty("balance")
    private Double balance;
}
