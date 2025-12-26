package com.example.demo.controller;

import com.example.demo.model.TransactionLog;
import com.example.demo.service.TransactionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping
    public TransactionLog create(@RequestBody TransactionLog transactionLog) {
        return transactionService.createTransaction(transactionLog);
    }

    @GetMapping
    public List<TransactionLog> getAll() {
        return transactionService.getAllTransactions();
    }

    @GetMapping("/{id}")
    public TransactionLog getById(@PathVariable Long id) {
        return transactionService.getTransactionById(id);
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