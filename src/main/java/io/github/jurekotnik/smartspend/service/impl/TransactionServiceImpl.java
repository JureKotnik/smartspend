package io.github.jurekotnik.smartspend.service.impl;

import io.github.jurekotnik.smartspend.entity.Transaction;
import io.github.jurekotnik.smartspend.repository.TransactionRepository;
import io.github.jurekotnik.smartspend.service.TransactionService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository repository;

    public TransactionServiceImpl(TransactionRepository repository) {
        this.repository = repository;
    }

    @Override
    public Transaction saveTransaction(Transaction transaction) {
        return repository.save(transaction);
    }

    @Override
    public List<Transaction> getAllTransactions() {
        return repository.findAll();
    }

    @Override
    public Double getTotalBalance() {
        return repository.findAll()
                .stream()
                .mapToDouble(t -> "EXPENSE".equalsIgnoreCase(t.getType()) 
                                  ? -t.getAmount() 
                                  : t.getAmount())
                .sum();
    }

    @Override
    public Transaction getTransactionById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transaction not found with id: " + id));
    }
}