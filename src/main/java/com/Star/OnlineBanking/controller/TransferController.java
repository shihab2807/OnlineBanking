package com.Star.OnlineBanking.controller;


import com.Star.OnlineBanking.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/transfer")
public class TransferController {

    @Autowired
    private TransferService transferService;

    @PostMapping
    public void transferMoney(@RequestParam Long fromAccountId, @RequestParam Long toAccountId, @RequestParam Double amount) {
        transferService.transferMoney(fromAccountId, toAccountId, amount);
    }
}
