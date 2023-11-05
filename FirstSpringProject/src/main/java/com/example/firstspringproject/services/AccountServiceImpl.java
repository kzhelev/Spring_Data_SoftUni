package com.example.firstspringproject.services;

import com.example.firstspringproject.models.Account;
import com.example.firstspringproject.repositories.AccountRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountRepository accountRepository;

    public AccountServiceImpl(){}

    @Override
    @Transactional
    public void addAccount(Account account) {
        Account accountToBeAdded = accountRepository.findByNumber(account.getNumber());

        if (accountToBeAdded == null) {
            accountRepository.save(account);
        }
    }

    @Override
    @Transactional
    public void withdrawMoney(BigDecimal money, Integer id) {

        Account account = accountRepository.findAccountById(id);

        if (account != null && account.getUser() != null && account.getBalance().compareTo(money) >= 0) {
            account.setBalance(account.getBalance().subtract(money));
            accountRepository.save(account);
        } else {
            System.out.println("Something went wrong!");
        }
    }

    @Override
    @Transactional
    public void depositMoney(BigDecimal money, Integer id) {


        Account account = accountRepository.findAccountById(id);

        if (account != null && account.getUser() != null && money.compareTo(BigDecimal.valueOf(0)) >= 0) {
        account.setBalance(account.getBalance().add(money));
        accountRepository.save(account);
        } else {
            System.out.println("Something went wrong!");
        }
    }
}
