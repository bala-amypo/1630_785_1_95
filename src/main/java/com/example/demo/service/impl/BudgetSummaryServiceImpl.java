package com.example.demo.service.impl;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.BudgetSummaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.YearMonth;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BudgetSummaryServiceImpl implements BudgetSummaryService {
    private final BudgetSummaryRepository summaryRepo;
    private final BudgetPlanRepository planRepo;
    private final TransactionLogRepository transactionRepo;

    @Override
    public BudgetSummary generateSummary(Long userId, int month, int year) {
        BudgetPlan plan = planRepo.findByUserAndMonthAndYear(new User(userId, null, null, null, null), month, year)
                .orElseThrow(() -> new RuntimeException("Plan not found"));

        YearMonth ym = YearMonth.of(year, month);
        List<TransactionLog> logs = transactionRepo.findByUserAndTransactionDateBetween(
                plan.getUser(), ym.atDay(1), ym.atEndOfMonth());

        double income = logs.stream()
                .filter(l -> l.getCategory().getType().equals(Category.TYPE_INCOME))
                .mapToDouble(TransactionLog::getAmount).sum();
        
        double expense = logs.stream()
                .filter(l -> l.getCategory().getType().equals(Category.TYPE_EXPENSE))
                .mapToDouble(TransactionLog::getAmount).sum();

        BudgetSummary summary = new BudgetSummary();
        summary.setBudgetPlan(plan);
        summary.setTotalIncome(income);
        summary.setTotalExpense(expense);
        summary.setStatus(expense > plan.getExpenseLimit() ? 
                BudgetSummary.STATUS_EXCEEDED : BudgetSummary.STATUS_UNDER_LIMIT);

        return summaryRepo.save(summary);
    }

    @Override
    public BudgetSummary getSummaryByPlan(Long planId) {
        return summaryRepo.findByBudgetPlan(new BudgetPlan(planId, null, null, null, null, null))
                .orElseThrow(() -> new RuntimeException("Summary not found"));
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