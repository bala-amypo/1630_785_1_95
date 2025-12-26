package com.example.demo.model;

import com.example.demo.exception.BadRequestException;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "categories")
@Data 
@NoArgsConstructor 
@AllArgsConstructor
public class Category {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    
    private String type; // INCOME or EXPENSE
    
    public static final String TYPE_INCOME = "INCOME";
    public static final String TYPE_EXPENSE = "EXPENSE";

    public void validateType() {
        if (!TYPE_INCOME.equals(type) && !TYPE_EXPENSE.equals(type)) {
            throw new BadRequestException("Invalid Category Type: Must be INCOME or EXPENSE");
        }
    }
}









// package com.example.demo.model;

// import jakarta.persistence.Column;
// import jakarta.persistence.Entity;
// import jakarta.persistence.EnumType;
// import jakarta.persistence.Enumerated;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;

// import lombok.AllArgsConstructor;
// import lombok.Data;
// import lombok.NoArgsConstructor;

// @Entity
// @Data
// @NoArgsConstructor
// @AllArgsConstructor
// public class Category {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;   // PRIMARY KEY

//     @Column(nullable = false, unique = true)
//     private String name;   // NOT NULL + UNIQUE

//     @Enumerated(EnumType.STRING)
//     @Column(nullable = false)
//     private CategoryType type;   // INCOME / EXPENSE
// }
