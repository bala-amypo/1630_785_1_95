package com.example.demo.controller;

import com.example.demo.model.Category;
import com.example.demo.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public Category create(@RequestBody Category category) {
        return categoryService.createCategory(category);
    }

    @GetMapping
    public List<Category> getAll() {
        return categoryService.getAllCategories();
    }

    @GetMapping("/{id}")
    public Category getById(@PathVariable Long id) {
        return categoryService.getCategoryById(id);
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
// import com.example.demo.model.Category;
// import com.example.demo.service.CategoryService;
// import jakarta.validation.Valid;

// @RequestMapping("/Category")
// @RestController
// public class CategoryController{
//     @Autowired  CategoryService ser;
//     @PostMapping("/addtransaction")
//     public Category senddata(@RequestBody Category  stu){
//         return ser.postData3(stu);
//     }
//     @GetMapping("/gettransaction")
//     public List<Category> getVal(){
//         return ser.getAllData3();
//     }
//     @DeleteMapping("/delete/{id}")
//     public String dele(@PathVariable Long id){
//         return ser.DeleteData3(id);
//     }
//     @GetMapping("/find/{id}")
//     public Category  Find(@PathVariable Long id){
//         return ser.getData3(id);
//     }
//     @PutMapping("/put/{id}")
//     public Category  putVal(@PathVariable Long id,@RequestBody Category entity){
//         return ser.updateData3(id,entity);
//     }
// }