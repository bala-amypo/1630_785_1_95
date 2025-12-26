package com.example.demo.controller;

import com.example.demo.model.BudgetPlan;
import com.example.demo.service.BudgetPlanService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/budget-plans")
public class BudgetPlanController {

    private final BudgetPlanService budgetPlanService;

    public BudgetPlanController(BudgetPlanService budgetPlanService) {
        this.budgetPlanService = budgetPlanService;
    }

    @PostMapping
    public BudgetPlan create(@RequestBody BudgetPlan plan) {
        return budgetPlanService.createBudgetPlan(plan);
    }

    @GetMapping
    public List<BudgetPlan> getAll() {
        return budgetPlanService.getAllBudgetPlans();
    }

    @GetMapping("/{id}")
    public BudgetPlan getById(@PathVariable Long id) {
        return budgetPlanService.getBudgetPlanById(id);
    }
}











// package com.example.demo.controller;

// import java.util.*;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RestController;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import com.example.demo.model.BudgetPlan;
// import com.example.demo.service.BudgetPlanService;
// import jakarta.validation.Valid;

// @RequestMapping("/BudgetPlan")
// @RestController
// public class BudgetPlanController{
//     @Autowired  BudgetPlanService ser;
//     @PostMapping("/createbudgetplan")
//     public BudgetPlan senddata(@RequestBody BudgetPlan  stu){
//         return ser.postData5(stu);
//     }
//     @GetMapping("/getaspecificplan")
//     public List<BudgetPlan> getVal(){
//         return ser.getAllData5();
//     }
//     @DeleteMapping("/delete/{id}")
//     public String dele(@PathVariable Long id){
//         return ser.DeleteData5(id);
//     }
//     @GetMapping("/find/{id}")
//     public BudgetPlan  Find(@PathVariable Long id){
//         return ser.getData5(id);
//     }
//     @PutMapping("/put/{id}")
//     public BudgetPlan  putVal(@PathVariable Long id,@RequestBody BudgetPlan entity){
//         return ser.updateData5(id,entity);
//     }
// }