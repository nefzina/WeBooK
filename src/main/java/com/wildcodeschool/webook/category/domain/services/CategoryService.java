package com.wildcodeschool.webook.category.domain.services;

import com.wildcodeschool.webook.category.infrastructure.exception.NotFoundException;
import com.wildcodeschool.webook.category.infrastructure.repository.CategoryRepository;
import com.wildcodeschool.webook.category.domain.entity.Category;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    private final CategoryRepository repository;

    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }

    public List<Category> getAllCategory() {
        return repository.findAll();
    }

    public Category getOneCategory(Long id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException());
    }

    public Category addCategory(Category newCategory, Long id){
        return repository.save(newCategory);
    }

    public Category updateCategory(Category newCategory, Long id){
        return repository.findById(id)
                .map( category -> {
                    category.setType(newCategory.getType());
                    return repository.save(category);
                })
                .orElseThrow(() -> new NotFoundException());
    }

    public void deleteCategory(Long id) {
        repository.deleteById(id);
    }
}
