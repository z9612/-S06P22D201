package com.sbank.spring.dto;

import com.sbank.spring.entity.History;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HistoryDto {

    private String sender;

    private String receiver;

    private int statement;

    private int money;

    private String transactionDate;

    public static History toEntity(DepositDto depositDto, Long accountId) {
        return History.builder()
                    .accountId(accountId)
                    .sender(depositDto.getSender())
                    .receiver(depositDto.getReceiver())
                    .statement(depositDto.getStatement())
                    .money(depositDto.getMoney())
                    .transactionDate(depositDto.getTransactionDate())
                    .build();
    }

    public static HistoryDto from(History history) {
        if(history == null) return null;
        return HistoryDto.builder()
                    .sender(history.getSender())
                    .receiver(history.getReceiver())
                    .statement(history.getStatement())
                    .money(history.getMoney())
                    .transactionDate(history.getTransactionDate())
                    .build();
    }
}
