package com.example.demo.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

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
    @Column(nullable = false)
    private Double amount;   // > 0, NOT NULL

    @Column(nullable = false)
    private String description;   // NOT NULL

    @Column(nullable = false)
    private LocalDate transactionDate;   // NOT NULL
}
