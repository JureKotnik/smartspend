package io.github.jurekotnik.smartspend.controller;

import io.github.jurekotnik.smartspend.entity.Transaction;
import io.github.jurekotnik.smartspend.service.TransactionService; // Import Service, not Repository
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    // 👇 CHANGED: We use 'service', NOT 'repository'
    private final TransactionService service;

    // Constructor Injection
    public TransactionController(TransactionService service) {
        this.service = service;
    }

    @GetMapping("/balance")
    public Double getBalance() {
        return service.getTotalBalance();
    }

    @GetMapping
    public List<Transaction> getAll() {
        return service.getAllTransactions();
    }

    @GetMapping("/{id}")
    public Transaction getTransactionById(@PathVariable Long id) {
        return service.getTransactionById(id);
    }

    @PostMapping
    public Transaction create(@Valid @RequestBody Transaction transaction) {
        return service.saveTransaction(transaction);
    }
}