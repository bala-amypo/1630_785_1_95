package com.example.demo.service;

import com.example.demo.model.TransactionLog;
import java.util.List;

public interface TransactionService {
    TransactionLog createTransaction(TransactionLog transactionLog);
    List<TransactionLog> getAllTransactions();
    TransactionLog getTransactionById(Long id);
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