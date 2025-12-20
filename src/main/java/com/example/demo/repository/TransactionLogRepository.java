package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.model.TransactionLog;

@Repository
public interface TransactionLogRepository extends JpaRepository<TransactionLog,Long>{
    
}