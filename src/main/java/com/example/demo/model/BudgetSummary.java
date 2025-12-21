package com.example.demo.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
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

    // 🔗 One Summary → One BudgetPlan
    @OneToOne
    @JoinColumn(name = "budget_plan_id", nullable = false, unique = true)
    private BudgetPlan budgetPlan;

    @Column(nullable = false)
    private Double totalIncome;

    @Column(nullable = false)
    private Double totalExpense;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private BudgetStatus status;  // AUTO-CALCULATED

    @Column(nullable = false)
    private LocalDate generatedAt; // AUTO-SET

    @PrePersist
    protected void onCreate() {
        // Auto-set generation date
        this.generatedAt = LocalDate.now();

        // Auto-calculate status
        if (totalIncome != null && totalExpense != null
                && totalExpense <= totalIncome) {
            this.status = BudgetStatus.UNDER_LIMIT;
        } else {
            this.status = BudgetStatus.OVER_LIMIT;
        }
    }
}
