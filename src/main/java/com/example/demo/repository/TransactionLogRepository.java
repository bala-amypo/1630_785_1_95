package com.example.demo.repository;

import com.example.demo.model.TransactionLog;
import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface TransactionLogRepository extends JpaRepository<TransactionLog, Long> {
    List<TransactionLog> findByUser(User user);
    
    // Supports HQL/HCQL-style date range queries
    List<TransactionLog> findByUserAndTransactionDateBetween(User user, LocalDate startDate, LocalDate endDate);
}















// package com.example.demo.repository;

// import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.stereotype.Repository;
// import com.example.demo.model.TransactionLog;

// @Repository
// public interface TransactionLogRepository extends JpaRepository<TransactionLog,Long>{
    
// }