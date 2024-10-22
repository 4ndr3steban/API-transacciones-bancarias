package com.betek.proyectointegrador.services;

import com.betek.proyectointegrador.dtos.openaccount.OpenAccountDto;
import com.betek.proyectointegrador.repositories.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;

    public OpenAccountDto openAccount(OpenAccountDto openAccountDto) {
        return null;
    }
}
