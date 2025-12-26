package com.example.demo.service.impl;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.BudgetSummaryService;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;

public class BudgetSummaryServiceImpl implements BudgetSummaryService {

    private final BudgetSummaryRepository summaryRepository;
    private final BudgetPlanRepository planRepository;
    private final TransactionLogRepository transactionRepository;

    public BudgetSummaryServiceImpl(BudgetSummaryRepository summaryRepository,
                                    BudgetPlanRepository planRepository,
                                    TransactionLogRepository transactionRepository) {
        this.summaryRepository = summaryRepository;
        this.planRepository = planRepository;
        this.transactionRepository = transactionRepository;
    }

    @Override
    public BudgetSummary generateSummary(Long budgetPlanId) {
        BudgetPlan plan = planRepository.findById(budgetPlanId).orElseThrow();

        YearMonth ym = YearMonth.of(plan.getYear(), plan.getMonth());
        LocalDate start = ym.atDay(1);
        LocalDate end = ym.atEndOfMonth();

        List<TransactionLog> logs =
                transactionRepository.findByUserAndTransactionDateBetween(
                        plan.getUser(), start, end);

        double income = 0;
        double expense = 0;

        for (TransactionLog log : logs) {
            if (Category.TYPE_INCOME.equals(log.getCategory().getType())) {
                income += log.getAmount();
            } else {
                expense += log.getAmount();
            }
        }

        String status = expense <= plan.getExpenseLimit()
                ? BudgetSummary.STATUS_UNDER_LIMIT
                : BudgetSummary.STATUS_OVER_LIMIT;

        BudgetSummary summary = new BudgetSummary(
                null, plan, income, expense, status, null
        );

        return summaryRepository.save(summary);
    }

    @Override
    public BudgetSummary getSummary(Long budgetPlanId) {
        BudgetPlan plan = planRepository.findById(budgetPlanId).orElseThrow();
        return summaryRepository.findByBudgetPlan(plan).orElse(null);
    }
}










// package com.example.demo.service.impl;

// import java.util.List;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;   
// import com.example.demo.model.BudgetSummary;
// import com.example.demo.repository.BudgetSummaryRepository;
// import org.springframework.web.bind.annotation.PathVariable;
// import com.example.demo.service.BudgetSummaryService;                

// @Service
// public class BudgetSummaryServiceImpl implements BudgetSummaryService{

//     @Autowired BudgetSummaryRepository used;
//     @Override
//     public BudgetSummary postData4(BudgetSummary use){
//         return used.save(use);  
//     }
//     @Override
//     public List<BudgetSummary>getAllData4(){
//         return used.findAll();
//     }
//     @Override
//     public String DeleteData4(Long id){
//         used.deleteById(id);
//         return "Deleted successfully";
//     }
//     @Override
//     public BudgetSummary getData4(Long id){
//     return used.findById(id).orElse(null);
//     }
//     @Override
//     public BudgetSummary updateData4(Long id,BudgetSummary entity){
//         if(used.existsById(id)){
//             entity.setId(id);
//             return used.save(entity);
//         } 
//         return null;
//     }
// }