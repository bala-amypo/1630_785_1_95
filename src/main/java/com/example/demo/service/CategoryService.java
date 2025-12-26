package com.example.demo.service;

import com.example.demo.model.Category;

import java.util.List;

public interface CategoryService {
    // used by tests
    Category addCategory(Category category);
    List<Category> getAllCategories();

    // used by CategoryController
    default Category createCategory(Category category) {
        return addCategory(category);
    }

    default Category getCategoryById(Long id) {
        // simple stub; controllers may call this
        return null;
    }
}






// package com.example.demo.service;

// import java.util.List;
// import com.example.demo.model.Category;

// public interface CategoryService{
//     Category postData3(Category use);
//     List<Category>getAllData3();
//     String  DeleteData3(Long id);
//     Category getData3(Long id);         
//     Category updateData3(Long id,Category entity);                                                        
// }