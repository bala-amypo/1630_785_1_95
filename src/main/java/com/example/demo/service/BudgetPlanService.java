package com.example.demo.service;

import com.example.demo.model.BudgetPlan;

public interface BudgetPlanService {

    BudgetPlan createBudgetPlan(Long userId, BudgetPlan plan);

    BudgetPlan getBudgetPlan(Long userId, Integer month, Integer year);
}





// package com.example.demo.service;

// import java.util.List;
// import com.example.demo.model.BudgetPlan;

// public interface BudgetPlanService{
//     BudgetPlan postData5(BudgetPlan use);
//     List<BudgetPlan>getAllData5();
//     String  DeleteData5(Long id);
//     BudgetPlan getData5(Long id);         
//     BudgetPlan updateData5(Long id,BudgetPlan entity);                                                        
// }