package org.fintrack.controller;

import org.fintrack.entity.Transaction;
import org.fintrack.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/transactions")
public class TransactionController {

    private TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService){
        this.transactionService = transactionService;
    }

    @GetMapping
    public List<Transaction> getTransactions(){
        return transactionService.findAllTransactions();
    }
    @PostMapping
    public Transaction createTransaction(@RequestBody Transaction newTransaction){
        return transactionService.createTransaction(newTransaction);
    }
}
