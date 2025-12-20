package com.example.demo.service;

import java.util.List;
import com.example.demo.model.TransactionLog;

public interface TransactionService{
    TransactionLog postData2(TransactionLog use);
    List<Tr>getAllData2();
    String  DeleteData2(Long id);
    User getData2(Long id);         
    User updateData2(Long id,User entity);                                                        
}