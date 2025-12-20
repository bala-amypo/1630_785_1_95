package com.example.demo.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BudgetSummary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;   // PRIMARY KEY

    @Column(nullable = false)
    private Double totalIncome;   // NOT NULL

    @Column(nullable = false)
    private Double totalExpense;  // NOT NULL

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private BudgetStatus status;  // UNDER_LIMIT / OVER_LIMIT

    @Column(nullable = false)
    private LocalDate generatedAt; // auto-set

    @PrePersist
    protected void onCreate() {
        // Auto-generate timestamp
        this.generatedAt = LocalDate.now();

        // Auto-calculate status
        if (totalExpense != null && totalIncome != null &&
            totalExpense <= totalIncome) {
            this.status = BudgetStatus.UNDER_LIMIT;
        } else {
            this.status = BudgetStatus.OVER_LIMIT;
        }
    }
}
