package com.example.example1_seminar5.service;

import com.example.example1_seminar5.exception.AccountNotFoundException;
import com.example.example1_seminar5.exception.NegativeBalanceException;
import com.example.example1_seminar5.model.Account;
import com.example.example1_seminar5.repository.AccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@AllArgsConstructor
public class TransferService {
    private  final AccountRepository accountRepository;

    public void transferMoney(long idSender, long idReceiver, BigDecimal amount) {
        Account sender = accountRepository.findById(idSender)
                //.orElseThrow(() -> new AccountNotFoundException()); заменено
                .orElseThrow(AccountNotFoundException::new);

        Account receiver = accountRepository.findById(idReceiver)
                .orElseThrow(AccountNotFoundException::new);
        if (sender.getAmount().compareTo(amount) >= 0) {
            BigDecimal senderNewAmount = sender.getAmount().subtract(amount);
            BigDecimal receiverNewAmount = receiver.getAmount().add(amount);

            accountRepository.changeAmount(idSender, senderNewAmount);
            accountRepository.changeAmount(idReceiver, receiverNewAmount);
        }else {
            throw new NegativeBalanceException("Недостаточно средств на счете отправителя.");
        }
    }


    public Iterable<Account> getAllAccounts(){
        return accountRepository.findAll();
    }

    public List<Account> findAccountByName(String name){
        return accountRepository.findAccountByName(name);
    }
}
