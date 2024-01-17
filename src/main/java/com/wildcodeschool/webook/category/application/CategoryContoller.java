package com.wildcodeschool.webook.category.application;

import com.wildcodeschool.webook.category.domain.services.CategoryService;
import com.wildcodeschool.webook.category.domain.entity.Category;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryContoller {
    CategoryService categoryService;

    public CategoryContoller(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    @GetMapping("/categories")
    List<Category> readAll() {
        return categoryService.getAllCategory();
    }

    @GetMapping("/categories/{id}")
    public Category readOne(@PathVariable Long id){
        return categoryService.getOneCategory(id);
    }

    @PutMapping("/categories/{id}")
    public Category edit(@RequestBody Category newCategory, @PathVariable Long id) {
        return categoryService.updateCategory(newCategory, id);
    }

    @DeleteMapping("/categories/{id}")
    public void delete(@PathVariable Long id) {
        categoryService.deleteCategory(id);
    }


}
