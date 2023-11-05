package com.example.firstspringproject;

import com.example.firstspringproject.models.Account;
import com.example.firstspringproject.models.User;
import com.example.firstspringproject.services.AccountNumberService;
import com.example.firstspringproject.services.AccountService;
import com.example.firstspringproject.services.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ConsoleRunner implements CommandLineRunner {

    private UserService userService;
    private AccountService accountService;
    private AccountNumberService accountNumberService;

    @Autowired
    public ConsoleRunner(UserService userService, AccountService accountService, AccountNumberService accountNumberService) {
        this.userService = userService;
        this.accountService = accountService;
        this.accountNumberService = accountNumberService;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {

        User user = new User("Gosho", 22);

        Account account = new Account(new BigDecimal("19000"), accountNumberService.getNumber());
        account.setUser(user);

        user.addAccount(account);

        userService.registerUser(user);
        account.setUser(userService.getUser(user));
        accountService.addAccount(account);

        accountService.withdrawMoney(new BigDecimal("200000"),7);
        accountService.depositMoney(new BigDecimal("30000"),7);
    }
}
