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

    public static History toEntity(TransferDto transferDto, Long accountId) {
        return History.builder()
                    .accountId(accountId)
                    .sender(transferDto.getSender())
                    .receiver(transferDto.getReceiver())
                    .statement(transferDto.getStatement())
                    .money(transferDto.getMoney())
                    .transactionDate(transferDto.getTransactionDate())
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
