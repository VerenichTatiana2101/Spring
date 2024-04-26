package com.example.example1_seminar5.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class TransferRequest {
    private Long senderAccountId; // отправитель
    private Long receiveAccountId; //получатель
    private BigDecimal amount; // размер перевода
}
