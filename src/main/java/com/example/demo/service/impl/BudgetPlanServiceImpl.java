package com.example.demo.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;   
import com.example.demo.model.BudgetPlan;
import com.example.demo.repository.BudgetPlanRepository;
import org.springframework.web.bind.annotation.PathVariable;
import com.example.demo.service.BudgetPlanService;                

@Service
public class BudgetPlanServiceImpl implements BudgetPlanService{

    @Autowired BudgetPlanRepository used;
    @Override
    public BudgetPlan postData5(BudgetPlan use){
        return used.save(use);  
    }
    @Override
    public List<BudgetPlan>getAllData5(){
        return used.findAll();
    }
    @Override
    public String DeleteData5(Long id){
        used.deleteById(id);
        return "Deleted successfully";
    }
    @Override
    public BudgetPlan getData5(Long id){
    return used.findById(id).orElse(null);
    }
    @Override
    public BudgetPlan updateData5(Long id,BudgetPlan entity){
        if(used.existsById(id)){
            entity.setId(id);
            return used.save(entity);
        } 
        return null;
    }
}