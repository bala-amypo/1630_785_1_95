package com.example.demo.controller;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import com.example.demo.model.TransactionLog;
import com.example.demo.service.TransactionService;
import jakarta.validation.Valid;

@RestController
public class TransactionLogController{
    @Autowired  TransactionService ser;
    @PostMapping("/createcategory")
    public TransactionLog sendData(@RequestBody TransactionLog  stu){
        return ser.postData2(stu);
    }
    @GetMapping("/listallcategories")
    public List<TransactionLog> getval(){
        return ser.getAllData2();
    }
    @DeleteMapping("/delete/{id}")
    public String del(@PathVariable Long id){
        return ser.DeleteData2(id);
    }
    @GetMapping("/find/{id}")
    public TransactionLog  find(@PathVariable Long id){
        return ser.getData2(id);
    }
    @PutMapping("/put/{id}")
    public TransactionLog  putval(@PathVariable Long id,@RequestBody TransactionLog  entity){
        return ser.updateData2(id,entity);
    }
}