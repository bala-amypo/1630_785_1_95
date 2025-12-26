package com.example.demo.model;

import com.example.demo.exception.BadRequestException;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "transaction_logs")
@Data 
@NoArgsConstructor 
@AllArgsConstructor
public class TransactionLog {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne 
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    
    @ManyToOne 
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;
    
    private Double amount;
    private String note;
    private LocalDate transactionDate;

    public void validate() {
        if (amount == null || amount <= 0) {
            throw new BadRequestException("Amount must be positive");
        }
        if (transactionDate != null && transactionDate.isAfter(LocalDate.now())) {
            throw new BadRequestException("Date cannot be in the future");
        }
    }
}

















// package com.example.demo.model;

// import java.math.BigDecimal;
// import java.time.LocalDate;

// import jakarta.persistence.Column;
// import jakarta.persistence.Entity;
// import jakarta.persistence.FetchType;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.JoinColumn;
// import jakarta.persistence.ManyToOne;

// import jakarta.validation.constraints.NotBlank;
// import jakarta.validation.constraints.NotNull;
// import jakarta.validation.constraints.PastOrPresent;
// import jakarta.validation.constraints.Positive;

// import lombok.AllArgsConstructor;
// import lombok.Data;
// import lombok.NoArgsConstructor;

// @Entity
// @Data
// @NoArgsConstructor
// @AllArgsConstructor
// public class TransactionLog {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @NotNull
//     @Positive(message = "Amount must be greater than 0")
//     @Column(nullable = false, precision = 12, scale = 2)
//     private BigDecimal amount;

//     @NotBlank(message = "Description cannot be blank")
//     @Column(nullable = false)
//     private String description;

//     @NotNull
//     @PastOrPresent(message = "Transaction date cannot be in the future")
//     @Column(nullable = false)
//     private LocalDate transactionDate;

//     // 🔗 Many Transactions → One User
//     @NotNull
//     @ManyToOne(fetch = FetchType.LAZY)
//     @JoinColumn(name = "user_id", nullable = false)
//     private User user;

//     // 🔗 Many Transactions → One Category
//     @NotNull
//     @ManyToOne(fetch = FetchType.LAZY)
//     @JoinColumn(name = "category_id", nullable = false)
//     private Category category;
// }
