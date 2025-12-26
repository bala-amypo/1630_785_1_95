package com.example.demo.model;

import com.example.demo.exception.BadRequestException;
import jakarta.persistence.*;

@Entity
public class BudgetPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    private Integer month;
    private Integer year;
    private Double incomeTarget;
    private Double expenseLimit;

    public BudgetPlan() {}

    public BudgetPlan(Long id, User user, Integer month, Integer year,
                      Double incomeTarget, Double expenseLimit) {
        this.id = id;
        this.user = user;
        this.month = month;
        this.year = year;
        this.incomeTarget = incomeTarget;
        this.expenseLimit = expenseLimit;
    }

    public void validate() {
        if (month < 1 || month > 12) {
            throw new BadRequestException("Invalid month");
        }
    }

    // getters & setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public Integer getMonth() { return month; }
    public Integer getYear() { return year; }
}















// package com.example.demo.model;

// import jakarta.persistence.Column;
// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.JoinColumn;
// import jakarta.persistence.ManyToOne;

// import jakarta.validation.constraints.Min;
// import jakarta.validation.constraints.Max;
// import jakarta.validation.constraints.PositiveOrZero;
// import jakarta.validation.constraints.NotNull;

// import lombok.AllArgsConstructor;
// import lombok.Data;
// import lombok.NoArgsConstructor;

// @Entity
// @Data
// @NoArgsConstructor
// @AllArgsConstructor
// public class BudgetPlan {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     //Many budgets → One user
//     @ManyToOne
//     @JoinColumn(name = "user_id", nullable = false)
//     private User user;

//     @NotNull
//     @Min(value = 1, message = "Month must be between 1 and 12")
//     @Max(value = 12, message = "Month must be between 1 and 12")
//     @Column(nullable = false)
//     private Integer month;   // 1–12

//     @NotNull
//     @Min(value = 2000, message = "Year must be valid")
//     @Column(nullable = false)
//     private Integer year;

//     @NotNull
//     @PositiveOrZero(message = "Income target must be >= 0")
//     @Column(nullable = false)
//     private Double incomeTarget;

//     @NotNull
//     @PositiveOrZero(message = "Expense limit must be >= 0")
//     @Column(nullable = false)
//     private Double expenseLimit;
// }
