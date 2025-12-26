package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@Data 
@NoArgsConstructor 
@AllArgsConstructor
public class User {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    
    @Column(unique = true, nullable = false)
    private String email;
    
    @Column(nullable = false)
    private String password;
    
    private String role;
    
    public static final String ROLE_USER = "ROLE_USER";
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
// public class User {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;   

//     @Column(nullable = false)
//     private String name;   

//     @Column(nullable = false, unique = true)
//     private String email; 

//     @Column(nullable = false)
//     private String password;  

//     @Enumerated(EnumType.STRING)
//     @Column(nullable = false)
//     private Role role = Role.USER;   // USER / ADMIN
// }
