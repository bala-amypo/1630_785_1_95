// package com.example.demo.service.impl;

// import java.util.List;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;   
// import com.example.demo.model.TransactionLog;
// import com.example.demo.repository.TransactionLogRepository;
// import org.springframework.web.bind.annotation.PathVariable;
// import com.example.demo.service.TransactionService;                

// @Service
// public class TransactionPlanServiceImpl implements TransactionService{

//     @Autowired TransactionLogRepository used;
//     @Override
//     public TransactionLog postData2(TransactionLog use){
//         return used.save(use);  
//     }
//     @Override
//     public List<TransactionLog>getAllData2(){
//         return used.findAll();
//     }
//     @Override
//     public String DeleteData2(Long id){
//         used.deleteById(id);
//         return "Deleted successfully";
//     }
//     @Override
//     public TransactionLog getData2(Long id){
//     return used.findById(id).orElse(null);
//     }
//     @Override
//     public TransactionLog updateData2(Long id,TransactionLog entity){
//         if(used.existsById(id)){
//             entity.setId(id);
//             return used.save(entity);
//         } 
//         return null;
//     }
// }