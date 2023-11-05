package com.example.firstspringproject.services;

import com.example.firstspringproject.models.Account;
import com.example.firstspringproject.models.AccountNumber;
import com.example.firstspringproject.repositories.AccountNumberRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountNumberServiceImpl implements AccountNumberService {

    private AccountNumberRepository accountNumberRepository;

    @Autowired
    public AccountNumberServiceImpl(AccountNumberRepository accountNumberRepository){
        this.accountNumberRepository = accountNumberRepository;
    }

    @Override
    @Transactional
    public Integer getNumber() {

        int accountNumber;

        List<AccountNumber> accountNumbers = accountNumberRepository.findAll();

        if (accountNumbers.size() == 0) {
            accountNumber = 1;
        } else {
            accountNumber = accountNumbers.get(accountNumbers.size()-1).getNumber()+1;
        }

        AccountNumber accNum = new AccountNumber();
        accNum.setNumber(accountNumber);

        accountNumberRepository.save(accNum);

        return accountNumber;
    }
}
