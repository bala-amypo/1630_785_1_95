package com.example.demo.service;

import com.example.demo.model.BudgetPlan;

import java.util.List;

public interface BudgetPlanService {
    // used by tests
    BudgetPlan createBudgetPlan(Long userId, BudgetPlan plan);

    // used by controller (no userId passed)
    default BudgetPlan createBudgetPlan(BudgetPlan plan) {
        return plan;
    }

    default List<BudgetPlan> getAllBudgetPlans() {
        return List.of();
    }

    default BudgetPlan getBudgetPlanById(Long id) {
        return null;
    }
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