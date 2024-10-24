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

    @PostMapping("/accounts")
    public ResponseEntity<OpenAccountResponseDto> openAccount(@RequestBody OpenAccountDto openAccountDto){
        return new ResponseEntity<>(accountService.openAccount(openAccountDto), HttpStatus.OK);
    }

    @PostMapping("/accounts/{account_number}/deposit")
    public ResponseEntity<DepositAccountResponseDto> depositAccount(@PathVariable("account_number") String accountNumber,
                                                                    @RequestBody DepositAccountDto depositAccountDto){
        return new ResponseEntity<>(accountService.depositAccount(accountNumber, depositAccountDto), HttpStatus.OK);
    }

    @PostMapping("/accounts/transfer")
    public ResponseEntity<TransferResponseDto> transferAccount(@RequestBody TransferDto transferDto){
        return new ResponseEntity<>(accountService.transfer(transferDto), HttpStatus.OK);
    }

    @GetMapping("/accounts/{account_number}")
    public ResponseEntity<AccountDto> transferAccount(@PathVariable("account_number") String accountNumber){
        return new ResponseEntity<>(accountService.getAccount(accountNumber), HttpStatus.OK);
    }

    @GetMapping("/accounts/{account_number}/pockets")
    public ResponseEntity<List<PocketDto>> getPockets(@PathVariable("account_number") String accountNumber){
        return new ResponseEntity<>(pocketService.getPockets(accountNumber), HttpStatus.OK);
    }
}
