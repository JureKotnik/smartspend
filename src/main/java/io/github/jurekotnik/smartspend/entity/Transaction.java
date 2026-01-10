package io.github.jurekotnik.smartspend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotBlank(message = "Description is required")
    @Size(min = 3, message = "Description must be at least 3 chars")
    private String description;

    @Column(nullable = false)
    @NotNull(message = "Amount is required")
    @Positive(message = "Amount must be greater than zero")
    private Double amount;

    @Column(nullable = false)
    @NotBlank(message = "Type is required (INCOME or EXPENSE)")
    private String type; 

    @PastOrPresent(message = "Date cannot be in the future")
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}