package com.example.demo.controller;

import com.example.demo.model.TransactionLog;
import com.example.demo.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
@RequiredArgsConstructor
public class TransactionController {
    private final TransactionService transactionService;

    @PostMapping("/user/{userId}")
    public ResponseEntity<TransactionLog> addTransaction(@PathVariable Long userId, @RequestBody TransactionLog log) {
        return ResponseEntity.ok(transactionService.addTransaction(userId, log));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<TransactionLog>> getUserTransactions(@PathVariable Long userId) {
        return ResponseEntity.ok(transactionService.getUserTransactions(userId));
    }
}







// package com.example.demo.controller;

// import java.util.*;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RestController;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import com.example.demo.model.TransactionLog;
// import com.example.demo.service.TransactionService;
// import jakarta.validation.Valid;

// @RequestMapping("/TransactionLog")
// @RestController
// public class TransactionLogController{
//     @Autowired  TransactionService ser;
//     @PostMapping("/createcategory")
//     public TransactionLog senddata(@RequestBody TransactionLog  stu){
//         return ser.postData2(stu);
//     }
//     @GetMapping("/listallcategories")
//     public List<TransactionLog> getVal(){
//         return ser.getAllData2();
//     }
//     @DeleteMapping("/delete/{id}")
//     public String dele(@PathVariable Long id){
//         return ser.DeleteData2(id);
//     }
//     @GetMapping("/find/{id}")
//     public TransactionLog  Find(@PathVariable Long id){
//         return ser.getData2(id);
//     }
//     @PutMapping("/put/{id}")
//     public TransactionLog  putVal(@PathVariable Long id,@RequestBody TransactionLog  entity){
//         return ser.updateData2(id,entity);
//     }
// }