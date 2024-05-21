package com.example.stockmanagement.service;

import com.example.stockmanagement.repository.CategoryRepository;
import com.example.stockmanagement.entity.Category;
import com.example.stockmanagement.exception.CategoryNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Category findById(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new CategoryNotFoundException("Invalid category id: " + id));
    }

    public String getCategoryNameById(Long id) {
        return findById(id).getName();
    }

}
