package org.fintrack.service;


import org.fintrack.entity.Transaction;
import org.fintrack.exception.ResourceNotFoundException;
import org.fintrack.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    private TransactionRepository transactionRepository;

    @Autowired
    public TransactionService(TransactionRepository transactionRepository){
        this.transactionRepository = transactionRepository;
    }

    public Transaction findTransactionById(Long id){
        return transactionRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Transaction not found" + id));
    }

    public Transaction createTransaction(Transaction newTransaction){
        return transactionRepository.save(newTransaction);
    }

}
