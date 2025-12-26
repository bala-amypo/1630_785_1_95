package com.example.demo.service.impl;

import com.example.demo.exception.BadRequestException;
import com.example.demo.model.BudgetPlan;
import com.example.demo.model.User;
import com.example.demo.repository.BudgetPlanRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.BudgetPlanService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BudgetPlanServiceImpl implements BudgetPlanService {
    private final BudgetPlanRepository planRepo;
    private final UserRepository userRepo;

    @Override
    public BudgetPlan createBudgetPlan(Long userId, BudgetPlan plan) {
        User user = userRepo.findById(userId)
                .orElseThrow(() -> new BadRequestException("User not found"));
        if (planRepo.findByUserAndMonthAndYear(user, plan.getMonth(), plan.getYear()).isPresent()) {
            throw new BadRequestException("Plan already exists for this period");
        }
        plan.setUser(user);
        plan.validate();
        return planRepo.save(plan);
    }

    @Override
    public BudgetPlan getBudgetPlan(Long userId, int month, int year) {
        User user = userRepo.findById(userId)
                .orElseThrow(() -> new BadRequestException("User not found"));
        return planRepo.findByUserAndMonthAndYear(user, month, year)
                .orElseThrow(() -> new BadRequestException("Budget plan not found"));
    }

    @Override
    public BudgetPlan updateBudgetPlan(Long planId, BudgetPlan updatedPlan) {
        BudgetPlan existing = planRepo.findById(planId)
                .orElseThrow(() -> new BadRequestException("Plan not found"));
        existing.setExpenseLimit(updatedPlan.getExpenseLimit());
        existing.setExpectedIncome(updatedPlan.getExpectedIncome());
        return planRepo.save(existing);
    }
}










// package com.example.demo.service.impl;

// import java.util.List;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;   
// import com.example.demo.model.BudgetPlan;
// import com.example.demo.repository.BudgetPlanRepository;
// import org.springframework.web.bind.annotation.PathVariable;
// import com.example.demo.service.BudgetPlanService;                

// @Service
// public class BudgetPlanServiceImpl implements BudgetPlanService{

//     @Autowired BudgetPlanRepository used;
//     @Override
//     public BudgetPlan postData5(BudgetPlan use){
//         return used.save(use);  
//     }
//     @Override
//     public List<BudgetPlan>getAllData5(){
//         return used.findAll();
//     }
//     @Override
//     public String DeleteData5(Long id){
//         used.deleteById(id);
//         return "Deleted successfully";
//     }
//     @Override
//     public BudgetPlan getData5(Long id){
//     return used.findById(id).orElse(null);
//     }
//     @Override
//     public BudgetPlan updateData5(Long id,BudgetPlan entity){
//         if(used.existsById(id)){
//             entity.setId(id);
//             return used.save(entity);
//         } 
//         return null;
//     }
// }