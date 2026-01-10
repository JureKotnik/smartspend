package io.github.jurekotnik.smartspend.service;

import io.github.jurekotnik.smartspend.entity.Transaction;
import java.util.List;

public interface TransactionService {
    Transaction saveTransaction(Transaction transaction);
    List<Transaction> getAllTransactions();
    Double getTotalBalance();
    Transaction getTransactionById(Long id);
}