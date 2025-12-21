package com.example.demo.service;

import java.util.List;
import com.example.demo.model.BudgetSummary;

public interface BudgetSummaryService{
    BudgetSummary postData3(BudgetSummary use);
    List<BudgetSummary>getAllData3();
    String  DeleteData3(Long id);
    BudgetSummary getData3(Long id);         
    Category updateData3(Long id,Category entity);                                                        
}