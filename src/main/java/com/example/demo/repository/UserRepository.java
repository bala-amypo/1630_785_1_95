package com.example.demo.repository;

import com.example.demo.model.TransactionLog;
import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface TransactionLogRepository extends JpaRepository<TransactionLog, Long> {
    List<TransactionLog> findByUser(User user);
    List<TransactionLog> findByUserAndTransactionDateBetween(
            User user, LocalDate start, LocalDate end);
}










// package com.example.demo.repository;

// import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.stereotype.Repository;
// import com.example.demo.model.User;

// @Repository
// public interface UserRepository extends JpaRepository<User,Long>{

// }