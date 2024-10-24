package com.betek.proyectointegrador.services;

import com.betek.proyectointegrador.dtos.PocketDto;
import com.betek.proyectointegrador.dtos.createpocket.CreatePocketDto;
import com.betek.proyectointegrador.dtos.createpocket.CreatePocketResponseDto;
import com.betek.proyectointegrador.dtos.transfers.PocketTransferDto;
import com.betek.proyectointegrador.dtos.transfers.PocketTransferResponseDto;
import com.betek.proyectointegrador.exceptions.BusinessException;
import com.betek.proyectointegrador.exceptions.ErrorMessage;
import com.betek.proyectointegrador.models.Account;
import com.betek.proyectointegrador.models.Pocket;
import com.betek.proyectointegrador.models.PocketPrimaryKey;
import com.betek.proyectointegrador.repositories.AccountRepository;
import com.betek.proyectointegrador.repositories.PocketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PocketService {

    private final PocketRepository pocketRepository;
    private final AccountRepository accountRepository;

    public CreatePocketResponseDto createPocket(CreatePocketDto createPocketDto) {

        if (createPocketDto.getAccountNumber() == null) {
            throw new BusinessException(ErrorMessage.PARAMETER_NOT_FOUND);
        }

        Account account = accountRepository.findById(createPocketDto.getAccountNumber())
                .orElseThrow(() -> new BusinessException(ErrorMessage.PRODUCT_NOT_FOUND));


        PocketPrimaryKey pocketPrimaryKey = PocketPrimaryKey.builder()
                .parentAccountNumber(account.getAccountNumber())
                .pocketNumber(String.format("P%03d", pocketRepository.countByPocketPrimaryKey_ParentAccountNumber(account.getAccountNumber()) + 1))
                .build();

        Pocket newPocket = Pocket.builder()
                .pocketPrimaryKey(pocketPrimaryKey)
                .name(createPocketDto.getName()==null ? " " : createPocketDto.getName())
                .balance(createPocketDto.getInitialBalance() == null ? 0 : createPocketDto.getInitialBalance())
                .build();

        pocketRepository.save(newPocket);

        CreatePocketResponseDto newPocketResponse = CreatePocketResponseDto.builder()
                .accountNumber(account.getAccountNumber())
                .pocketNumber(newPocket.getPocketPrimaryKey().getPocketNumber())
                .initialBalance(newPocket.getBalance())
                .build();

        return newPocketResponse;
    }

    public List<PocketDto> getPockets(String accountNumber) {

        Account account = accountRepository.findById(accountNumber)
                .orElseThrow(() -> new BusinessException(ErrorMessage.PRODUCT_NOT_FOUND));

        ArrayList<PocketDto> pocketDtos = new ArrayList<>();

        pocketRepository.findByPocketPrimaryKey_ParentAccountNumber(accountNumber)
                .stream().forEach(pocket -> pocketDtos.add(PocketDto.builder()
                                .name(pocket.getName())
                                .pocketNumber(pocket.getPocketPrimaryKey().getPocketNumber())
                                .amount(pocket.getBalance())
                        .build()));

        return pocketDtos;
    }

    public PocketTransferResponseDto pocketTransfer(PocketTransferDto pocketTransferDto) {

        if (pocketTransferDto.getAccountNumber()==null || pocketTransferDto.getPocketNumber()==null || pocketTransferDto.getAmount()==null){
            throw new BusinessException(ErrorMessage.PARAMETER_NOT_FOUND);
        }

        Account sourseAccount = accountRepository.findById(pocketTransferDto.getAccountNumber())
                .orElseThrow(() -> new BusinessException(ErrorMessage.PRODUCT_NOT_FOUND));

        Pocket destinationPocket = pocketRepository.findByPocketPrimaryKey_PocketNumberAndPocketPrimaryKey_ParentAccountNumber(pocketTransferDto.getPocketNumber(), pocketTransferDto.getAccountNumber())
                .orElseThrow(() -> new BusinessException(ErrorMessage.PRODUCT_NOT_FOUND));


        if (sourseAccount.getBalance()-pocketTransferDto.getAmount() < 0) {
            return PocketTransferResponseDto.builder()
                    .transferResponse("Transferencia fallida por falta de dinero en la cuenta origen")
                    .build();
        } else {
            sourseAccount.setBalance(sourseAccount.getBalance()-pocketTransferDto.getAmount());
            destinationPocket.setBalance(destinationPocket.getBalance()+pocketTransferDto.getAmount());

            accountRepository.save(sourseAccount);
            pocketRepository.save(destinationPocket);

            return PocketTransferResponseDto.builder()
                    .transferResponse("Transferencia exitosa")
                    .build();
        }

    }
}

