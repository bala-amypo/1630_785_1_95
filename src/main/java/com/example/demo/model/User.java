package com.example.model;

import java

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class User{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(unique = true)
    private String email;
    private String role;
}