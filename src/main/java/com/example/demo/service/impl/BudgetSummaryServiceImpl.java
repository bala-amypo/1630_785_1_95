package com.example.demo.service.impl;

import com.example.demo.repository.BudgetPlanRepository;
import com.example.demo.repository.BudgetSummaryRepository;
import com.example.demo.repository.TransactionLogRepository;
import com.example.demo.service.BudgetSummaryService;

public class BudgetSummaryServiceImpl implements BudgetSummaryService {

    private final BudgetSummaryRepository budgetSummaryRepository;
    private final BudgetPlanRepository budgetPlanRepository;
    private final TransactionLogRepository transactionLogRepository;

    public BudgetSummaryServiceImpl(BudgetSummaryRepository budgetSummaryRepository,
                                    BudgetPlanRepository budgetPlanRepository,
                                    TransactionLogRepository transactionLogRepository) {
        this.budgetSummaryRepository = budgetSummaryRepository;
        this.budgetPlanRepository = budgetPlanRepository;
        this.transactionLogRepository = transactionLogRepository;
    }

    // No methods needed for current tests
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