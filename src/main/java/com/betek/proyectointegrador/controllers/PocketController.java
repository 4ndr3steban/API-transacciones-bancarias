package com.betek.proyectointegrador.controllers;

import com.betek.proyectointegrador.dtos.createpocket.CreatePocketDto;
import com.betek.proyectointegrador.dtos.createpocket.CreatePocketResponseDto;
import com.betek.proyectointegrador.dtos.openaccount.OpenAccountDto;
import com.betek.proyectointegrador.dtos.openaccount.OpenAccountResponseDto;
import com.betek.proyectointegrador.dtos.transfers.PocketTransferDto;
import com.betek.proyectointegrador.dtos.transfers.PocketTransferResponseDto;
import com.betek.proyectointegrador.services.PocketService;
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

    @PostMapping("/pockets")
    public ResponseEntity<CreatePocketResponseDto> openAccount(@RequestBody CreatePocketDto createPocketDto){
        return new ResponseEntity<>(pocketService.createPocket(createPocketDto), HttpStatus.OK);
    }

    @PostMapping("/pockets/transfer")
    public ResponseEntity<PocketTransferResponseDto> pocketTransfer(@RequestBody PocketTransferDto pocketTransferDto){
        return new ResponseEntity<>(pocketService.pocketTransfer(pocketTransferDto), HttpStatus.OK);
    }

}
