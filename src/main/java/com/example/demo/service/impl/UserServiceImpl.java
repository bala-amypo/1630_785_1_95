package com.example.demo.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;   
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.web.bind.annotation.PathVariable;
import com.example.demo.service.UserService;                

@Service
public class UserServiceImpl implements UserService{
    @Autowired USerRepository used;
    @Override
    public User postData(User use){
        return used.save(use);  
    }
    @Override
    public List<StudentEntity>getAllData(){
        return student.findAll();
    }
    @Override
    public String DeleteData(@PathVariable int id){
        student.deleteById(id);
        return "Deleted successfully";
    }
    @Override
    public StudentEntity getData(int id){
    return student.findById(id).orElse(null);
    }
    @Override
    public StudentEntity updateData(int id,StudentEntity entity){
        if(student.existsById(id)){
            entity.setId(id);
            return student.save(entity);
        } 
        return null;
    }
}