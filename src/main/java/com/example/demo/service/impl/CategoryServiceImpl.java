package com.example.demo.service.impl;

import com.example.demo.exception.BadRequestException;
import com.example.demo.model.Category;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.service.CategoryService;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category addCategory(Category category) {
        if (categoryRepository.existsByName(category.getName())) {
            throw new BadRequestException("Category already exists");
        }
        return categoryRepository.save(category);
    }

    @Override
    public List<Category> getAllCategories() {
        List<Category> list = categoryRepository.findAll();
        return list != null ? list : List.of();
    }
}















// package com.example.demo.service.impl;

// import java.util.List;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;   
// import com.example.demo.model.Category;
// import com.example.demo.repository.CategoryRepository;
// import org.springframework.web.bind.annotation.PathVariable;
// import com.example.demo.service.CategoryService;                

// @Service
// public class CategoryServiceImpl implements CategoryService{

//     @Autowired CategoryRepository used;
//     @Override
//     public Category postData3(Category use){
//         return used.save(use);  
//     }
//     @Override
//     public List<Category>getAllData3(){
//         return used.findAll();
//     }
//     @Override
//     public String DeleteData3(Long id){
//         used.deleteById(id);
//         return "Deleted successfully";
//     }
//     @Override
//     public Category getData3(Long id){
//     return used.findById(id).orElse(null);
//     }
//     @Override
//     public Category updateData3(Long id,Category entity){
//         if(used.existsById(id)){
//             entity.setId(id);
//             return used.save(entity);
//         } 
//         return null;
//     }
// }