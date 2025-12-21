package com.example.demo.service;

import java.util.List;
import com.example.demo.model.Category;

public interface CategoryService{
    Category postData3(Category use);
    List<Category>getAllData3();
    String  DeleteData3(Long id);
    Category getData3(Long id);         
    Category updateData3(Long id,Category entity);                                                        
}