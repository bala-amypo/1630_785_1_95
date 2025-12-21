package com.example.demo.service;

import java.util.List;
import com.example.demo.model.BudgetSummary;

public interface BudgetSummaryService{
    BudgetSummary postData4(BudgetSummary use);
    List<BudgetSummary>getAllData4();
    String  DeleteData4(Long id);
    BudgetSummary getData3(Long id);         
    BudgetSummary updateData3(Long id,BudgetSummary entity);                                                        
}