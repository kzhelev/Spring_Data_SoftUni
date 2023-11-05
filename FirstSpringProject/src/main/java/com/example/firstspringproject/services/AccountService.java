package com.example.firstspringproject.services;

import com.example.firstspringproject.models.Account;

import java.math.BigDecimal;

public interface AccountService {
    void addAccount(Account account);
    void withdrawMoney(BigDecimal money, Integer id);
    void depositMoney(BigDecimal money,Integer id);
}
