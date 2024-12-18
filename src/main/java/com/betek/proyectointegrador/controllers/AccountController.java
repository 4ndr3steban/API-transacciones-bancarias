package com.betek.proyectointegrador.controllers;

import com.betek.proyectointegrador.dtos.AccountDto;
import com.betek.proyectointegrador.dtos.PocketDto;
import com.betek.proyectointegrador.dtos.UserDto;
import com.betek.proyectointegrador.dtos.openaccount.OpenAccountDto;
import com.betek.proyectointegrador.dtos.openaccount.OpenAccountResponseDto;
import com.betek.proyectointegrador.dtos.transfers.DepositAccountDto;
import com.betek.proyectointegrador.dtos.transfers.DepositAccountResponseDto;
import com.betek.proyectointegrador.dtos.transfers.TransferDto;
import com.betek.proyectointegrador.dtos.transfers.TransferResponseDto;
import com.betek.proyectointegrador.services.AccountService;
import com.betek.proyectointegrador.services.PocketService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;
    private final PocketService pocketService;

    @Operation(summary = "Endpoint que permite crear o abrir una nueva cuenta")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200" , description = "Se creo exitosamente la cuenta.",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = OpenAccountResponseDto.class))
                    }),
            @ApiResponse(responseCode = "400" , description = "Hubo error de logica en la aplicacion o ingresaste mal los datos"),
    })
    @PostMapping("/accounts")
    public ResponseEntity<OpenAccountResponseDto> openAccount(@RequestBody OpenAccountDto openAccountDto){
        return new ResponseEntity<>(accountService.openAccount(openAccountDto), HttpStatus.OK);
    }

    @Operation(summary = "Endpoint que permite depositar dinero en una cuenta existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200" , description = "El deposito de dinero fue exitoso",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = DepositAccountResponseDto.class))
                    }),
            @ApiResponse(responseCode = "400" , description = "Hubo error de logica en la aplicacion o ingresaste mal los datos"),
    })
    @PostMapping("/accounts/{account_number}/deposit")
    public ResponseEntity<DepositAccountResponseDto> depositAccount(@PathVariable("account_number") String accountNumber,
                                                                    @RequestBody DepositAccountDto depositAccountDto){
        return new ResponseEntity<>(accountService.depositAccount(accountNumber, depositAccountDto), HttpStatus.OK);
    }

    @Operation(summary = "Endpoint que permite transferir dinero entre dos cuentas")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200" , description = "La transferencia se realiza de manera exitosa",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = TransferResponseDto.class))
                    }),
            @ApiResponse(responseCode = "400" , description = "Hubo error de logica en la aplicacion o ingresaste mal los datos"),
    })
    @PostMapping("/accounts/transfer")
    public ResponseEntity<TransferResponseDto> transferAccount(@RequestBody TransferDto transferDto){
        return new ResponseEntity<>(accountService.transfer(transferDto), HttpStatus.OK);
    }


    @Operation(summary = "Endpoint que permite obtener los datos de una cuenta")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200" , description = "Los datos de la cuenta se obtuvieron exitosamente"),
            @ApiResponse(responseCode = "400" , description = "Hubo error de logica en la aplicacion o ingresaste mal los datos"),
    })
    @GetMapping("/accounts/{account_number}")
    public ResponseEntity<AccountDto> getAccount(@PathVariable("account_number") String accountNumber){
        return new ResponseEntity<>(accountService.getAccount(accountNumber), HttpStatus.OK);
    }

    @Operation(summary = "Endpoint que permite obtener los bolsillos asociados a una cuenta")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200" , description = "Los datos de los bolsillos se obtuvieron exitosamente"),
            @ApiResponse(responseCode = "400" , description = "Hubo error de logica en la aplicacion o ingresaste mal los datos"),
    })
    @GetMapping("/accounts/{account_number}/pockets")
    public ResponseEntity<List<PocketDto>> getPockets(@PathVariable("account_number") String accountNumber){
        return new ResponseEntity<>(pocketService.getPockets(accountNumber), HttpStatus.OK);
    }
}
