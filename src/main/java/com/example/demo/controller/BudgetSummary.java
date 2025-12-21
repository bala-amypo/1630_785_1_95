package com.example.demo.controller;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.example.demo.model.BudgetSummary;
import com.example.demo.service.BudgetSummary;
import jakarta.validation.Valid;

@RequestMapping("/BudgetSummary")
@RestController
public class BudgetSummaryController{
    @Autowired  BudgetSummaryService ser;
    @PostMapping("/addtransaction")
    public BudgetSummary senddata(@RequestBody BudgetSummary  stu){
        return ser.postData4(stu);
    }
    @GetMapping("/gettransaction")
    public List<BudgetSummary> getVal(){
        return ser.getAllData4();
    }
    @DeleteMapping("/delete/{id}")
    public String dele(@PathVariable Long id){
        return ser.DeleteData4(id);
    }
    @GetMapping("/find/{id}")
    public BudgetSummary  Find(@PathVariable Long id){
        return ser.getData4(id);
    }
    @PutMapping("/put/{id}")
    public Category  putVal(@PathVariable Long id,@RequestBody Category entity){
        return ser.updateData3(id,entity);
    }
}