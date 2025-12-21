package com.example.demo.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;   // PRIMARY KEY

    @Positive(message = "Amount must be greater than 0")
    @NotNull
    @Column(nullable = false)
    private Double amount;   // > 0

    @NotNull
    @Column(nullable = false)
    private String description;   // NOT NULL

    @NotNull
    @PastOrPresent(message = "Transaction date cannot be in the future")
    @Column(nullable = false)
    private LocalDate transactionDate;

    // 🔗 Many Transactions → One User
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    // 🔗 Many Transactions → One Category
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;
}
