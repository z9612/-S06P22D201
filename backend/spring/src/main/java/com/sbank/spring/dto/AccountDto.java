package com.sbank.spring.dto;

import java.time.LocalDate;

import com.sbank.spring.entity.Account;

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
public class AccountDto {
    
    private String bankName;

    private String accountNumber;

    private int balance;

    private String creationDate;
    
    public static Account toEntity(Long memberNo, String accountNumber) {
        return Account.builder()
                    .memberNo(memberNo)
                    .bankName("SBank")
                    .accountNumber(accountNumber)
                    .balance(0)
                    .creationDate(LocalDate.now().toString())
                    .build();
    }

    public static AccountDto from(Account account) {
        if(account == null) return null;
        return AccountDto.builder()
                    .bankName(account.getBankName())
                    .accountNumber(account.getAccountNumber())
                    .balance(account.getBalance())
                    .creationDate(account.getCreationDate())
                    .build();
    }
}