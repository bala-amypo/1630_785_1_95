package com.example.demo.service;

import com.example.demo.model.TransactionLog;

import java.util.List;

public interface TransactionService {
    // used by tests
    TransactionLog addTransaction(Long userId, TransactionLog log);
    List<TransactionLog> getUserTransactions(Long userId);

    // used by TransactionController
    default TransactionLog createTransaction(TransactionLog log) {
        // controller path where userId not provided; adapt as needed
        return log;
    }

    default List<TransactionLog> getAllTransactions() {
        return List.of();
    }

    default TransactionLog getTransactionById(Long id) {
        return null;
    }
}









// package com.example.demo.service;

// import java.util.List;
// import com.example.demo.model.TransactionLog;

// public interface TransactionService{
//     TransactionLog postData2(TransactionLog use);
//     List<TransactionLog>getAllData2();
//     String  DeleteData2(Long id);
//     TransactionLog getData2(Long id);         
//     TransactionLog updateData2(Long id,TransactionLog entity);                                                        
// }