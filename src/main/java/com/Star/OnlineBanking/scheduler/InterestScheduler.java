package com.Star.OnlineBanking.scheduler;


import com.Star.OnlineBanking.entity.Account;
import com.Star.OnlineBanking.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class InterestScheduler {

    @Autowired
    private AccountRepository accountRepository;

    @Scheduled(fixedRate = 60000) // Every minute
    public void calculateInterest() {
        List<Account> accounts = accountRepository.findAll();
        for (Account account : accounts) {
            double newBalance = account.getBalance() * 1.05;
            if (newBalance > account.getInitialBalance() * 2.07) {
                newBalance = account.getInitialBalance() * 2.07;
            }
            account.setBalance(newBalance);
            accountRepository.save(account);
        }
    }
}

