package com.example.example1_seminar5.controller;

import com.example.example1_seminar5.dto.TransferRequest;
import com.example.example1_seminar5.exception.NegativeBalanceException;
import com.example.example1_seminar5.model.Account;
import com.example.example1_seminar5.service.TransferService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class AccountController {

    private final TransferService transferService;

    @PostMapping("/transfer")
    public String transferMoney(@RequestBody TransferRequest request) {
        try {
            transferService.transferMoney(
                    request.getSenderAccountId(),
                    request.getReceiveAccountId(),
                    request.getAmount());
            return "перевод " + request.getAmount();
        } catch (NegativeBalanceException e) {
            return "Ошибка: Недостаточно средств на счете отправителя.";
        }
    }

    /* метод состояния счетов */
    @GetMapping("/accounts")
    public Iterable<Account> getAllAccounts(
            @RequestParam(required = false) String name) {
        if (name == null) return transferService.getAllAccounts();
        else return transferService.findAccountByName(name);
    }
}
