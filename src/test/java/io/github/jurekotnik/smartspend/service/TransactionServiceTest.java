package io.github.jurekotnik.smartspend.service;

import io.github.jurekotnik.smartspend.repository.TransactionRepository;
import io.github.jurekotnik.smartspend.service.impl.TransactionServiceImpl;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
public class TransactionServiceTest {

    @Mock
    private TransactionRepository repository;

    @InjectMocks
    private TransactionServiceImpl service;

}