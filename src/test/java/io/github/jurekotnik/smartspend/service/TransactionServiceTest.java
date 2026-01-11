package io.github.jurekotnik.smartspend.service;

import io.github.jurekotnik.smartspend.entity.Transaction;
import io.github.jurekotnik.smartspend.repository.TransactionRepository;
import io.github.jurekotnik.smartspend.service.impl.TransactionServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TransactionServiceTest {

    @Mock
    private TransactionRepository repository;

    @InjectMocks
    private TransactionServiceImpl service;

    @Test
    public void testGetTotalBalance_ShouldCalculateIncomeAndExpense() {
        Transaction salary = new Transaction();
        salary.setAmount(1000.0);
        salary.setType("INCOME");

        Transaction groceries = new Transaction();
        groceries.setAmount(100.0);
        groceries.setType("EXPENSE");
        when(repository.findAll()).thenReturn(Arrays.asList(salary, groceries));

        Double balance = service.getTotalBalance();
        assertEquals(900.0, balance, "Balance should be Income minus Expense");
    }

    @Test
    public void testGetTransactionById_ShouldThrowError_WhenNotFound() {

        when(repository.findById(99L)).thenReturn(Optional.empty());
        Exception exception = assertThrows(RuntimeException.class, () -> {
            service.getTransactionById(99L);
        });

        assertEquals("Transaction not found with id: 99", exception.getMessage());
    }
}