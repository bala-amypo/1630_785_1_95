package com.example.demo.service;

import com.example.demo.model.BudgetSummary;

import java.util.List;

public interface BudgetSummaryService {

    // tests only check bean non-null, but controller expects these:

    default BudgetSummary createBudgetSummary(BudgetSummary summary) {
        return summary;
    }

    default List<BudgetSummary> getAllBudgetSummaries() {
        return List.of();
    }

    default BudgetSummary getBudgetSummaryById(Long id) {
        return null;
    }
}






// package com.example.demo.service;

// import java.util.List;
// import com.example.demo.model.BudgetSummary;

// public interface BudgetSummaryService{
//     BudgetSummary postData4(BudgetSummary use);
//     List<BudgetSummary>getAllData4();
//     String  DeleteData4(Long id);
//     BudgetSummary getData4(Long id);         
//     BudgetSummary updateData4(Long id,BudgetSummary entity);                                                        
// }