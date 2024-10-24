package com.betek.proyectointegrador.services;

import com.betek.proyectointegrador.dtos.AccountDto;
import com.betek.proyectointegrador.dtos.UserDto;
import com.betek.proyectointegrador.dtos.openaccount.OpenAccountDto;
import com.betek.proyectointegrador.dtos.openaccount.OpenAccountResponseDto;
import com.betek.proyectointegrador.dtos.transfers.DepositAccountDto;
import com.betek.proyectointegrador.dtos.transfers.DepositAccountResponseDto;
import com.betek.proyectointegrador.dtos.transfers.TransferDto;
import com.betek.proyectointegrador.dtos.transfers.TransferResponseDto;
import com.betek.proyectointegrador.exceptions.BusinessException;
import com.betek.proyectointegrador.exceptions.ErrorMessage;
import com.betek.proyectointegrador.models.Account;
import com.betek.proyectointegrador.models.User;
import com.betek.proyectointegrador.repositories.AccountRepository;
import com.betek.proyectointegrador.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;
    private final UserRepository userRepository;

    public OpenAccountResponseDto openAccount(OpenAccountDto openAccountDto) {

        if (openAccountDto.getOwnerId()==null){
            throw new BusinessException(ErrorMessage.PARAMETER_NOT_FOUND);
        }

        Random random = new Random();
        ArrayList<String> registeredAccounts = new ArrayList<>();
        String newaccountNumber;

        accountRepository.findAll().stream()
                .forEach(account -> registeredAccounts.add(account.getAccountNumber()));

        do {
            newaccountNumber = String.format("%09d", random.nextInt(1000000000));
        } while (registeredAccounts.contains(newaccountNumber)); // Verifica la unicidad

        Account newAccount = Account.builder()
                .accountNumber(newaccountNumber)
                .ownerId(openAccountDto.getOwnerId())
                .balance(openAccountDto.getInitialBalance()==null ? 0 : openAccountDto.getInitialBalance())
                .build();

        accountRepository.save(newAccount);

        OpenAccountResponseDto newAccountResponse = OpenAccountResponseDto.builder()
                .accountNumber(newaccountNumber)
                .ownerId(openAccountDto.getOwnerId())
                .initialBalance(openAccountDto.getInitialBalance()==null ? 0 : openAccountDto.getInitialBalance())
                .build();

        return newAccountResponse;
    }

    public DepositAccountResponseDto depositAccount(String accountNumber, DepositAccountDto depositAccountDto) {

        if (depositAccountDto.getAmount()==null){
            throw new BusinessException(ErrorMessage.PARAMETER_NOT_FOUND);
        }

        Account account = accountRepository.findById(accountNumber)
                .orElseThrow(() -> new BusinessException(ErrorMessage.PRODUCT_NOT_FOUND));

        account.setBalance(account.getBalance()+ depositAccountDto.getAmount());

        accountRepository.save(account);

        DepositAccountResponseDto newBalance = DepositAccountResponseDto.builder()
                .accountNumber(account.getAccountNumber())
                .newAmount(account.getBalance())
                .build();

        return newBalance;
    }

    public TransferResponseDto transfer(TransferDto transferDto) {

        if (transferDto.getSourceAccountNumber()==null || transferDto.getDestinationAccountNumber()==null || transferDto.getAmount()==null){
            throw new BusinessException(ErrorMessage.PARAMETER_NOT_FOUND);
        }

        Account sourseAccount = accountRepository.findById(transferDto.getSourceAccountNumber())
                .orElseThrow(() -> new BusinessException(ErrorMessage.PRODUCT_NOT_FOUND));

        Account destinationAccount = accountRepository.findById(transferDto.getDestinationAccountNumber())
                .orElseThrow(() -> new BusinessException(ErrorMessage.PRODUCT_NOT_FOUND));


        if (sourseAccount.getBalance()-transferDto.getAmount() < 0) {
            return TransferResponseDto.builder()
                    .transferResult("Transferencia fallida por falta de dinero en la cuenta origen")
                    .build();
        } else {
            sourseAccount.setBalance(sourseAccount.getBalance()-transferDto.getAmount());
            destinationAccount.setBalance(destinationAccount.getBalance()+transferDto.getAmount());

            accountRepository.save(sourseAccount);
            accountRepository.save(destinationAccount);

            return TransferResponseDto.builder()
                    .transferResult("Transferencia exitosa")
                    .build();
        }

    }

    public AccountDto getAccount(String accountNumber) {

        Account account = accountRepository.findById(accountNumber)
                .orElseThrow(() -> new BusinessException(ErrorMessage.PRODUCT_NOT_FOUND));

        User user = userRepository.findById(account.getOwnerId())
                .orElseThrow(() -> new BusinessException(ErrorMessage.PRODUCT_NOT_FOUND));

        AccountDto accountDto = AccountDto.builder()
                .accountNumber(account.getAccountNumber())
                .balance(account.getBalance())
                .owner(UserDto.builder()
                        .id(user.getId())
                        .name(user.getName())
                        .email(user.getEmail())
                        .address(user.getAddress())
                        .build())
                .build();

        return accountDto;
    }

}
