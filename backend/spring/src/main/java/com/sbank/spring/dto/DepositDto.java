package com.sbank.spring.dto;

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
public class DepositDto {
    
    private String sender;

    private String senderAccount;

    private int statement;

    private int money;

    private String transactionDate;
}
