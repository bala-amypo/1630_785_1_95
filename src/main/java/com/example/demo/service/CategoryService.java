package com.example.demo.service;

import java.util.List;
import com.example.demo.model.Category;

public interface CategoryService{
    Category postData3(Category use);
    List<Category>getAllData2();
    String  DeleteData2(Long id);
    Category getData2(Long id);         
    Category updateData2(Long id,Category entity);                                                        
}