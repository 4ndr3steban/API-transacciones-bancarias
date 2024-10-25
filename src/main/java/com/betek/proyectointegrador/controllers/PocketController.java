package com.betek.proyectointegrador.controllers;

import com.betek.proyectointegrador.dtos.createpocket.CreatePocketDto;
import com.betek.proyectointegrador.dtos.createpocket.CreatePocketResponseDto;
import com.betek.proyectointegrador.dtos.openaccount.OpenAccountDto;
import com.betek.proyectointegrador.dtos.openaccount.OpenAccountResponseDto;
import com.betek.proyectointegrador.dtos.transfers.PocketTransferDto;
import com.betek.proyectointegrador.dtos.transfers.PocketTransferResponseDto;
import com.betek.proyectointegrador.dtos.transfers.TransferResponseDto;
import com.betek.proyectointegrador.services.PocketService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class PocketController {

    private final PocketService pocketService;

    @Operation(summary = "Endpoint crear un bolsillo en una cuenta")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200" , description = "El bolsillo se creó de forma exitosa",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = TransferResponseDto.class))
                    }),
            @ApiResponse(responseCode = "400" , description = "Hubo error de logica en la aplicacion o ingresaste mal los datos"),
    })
    @PostMapping("/pockets")
    public ResponseEntity<CreatePocketResponseDto> openAccount(@RequestBody CreatePocketDto createPocketDto){
        return new ResponseEntity<>(pocketService.createPocket(createPocketDto), HttpStatus.OK);
    }

    @Operation(summary = "Endpoint que permite transferir dinero de una cuenta a un bolsillo de dicha cuenta")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200" , description = "La transferencia se realiza de manera exitosa",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = TransferResponseDto.class))
                    }),
            @ApiResponse(responseCode = "400" , description = "Hubo error de logica en la aplicacion o ingresaste mal los datos"),
    })
    @PostMapping("/pockets/transfer")
    public ResponseEntity<PocketTransferResponseDto> pocketTransfer(@RequestBody PocketTransferDto pocketTransferDto){
        return new ResponseEntity<>(pocketService.pocketTransfer(pocketTransferDto), HttpStatus.OK);
    }

}
