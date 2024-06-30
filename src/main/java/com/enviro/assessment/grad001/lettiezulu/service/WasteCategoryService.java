package com.enviro.assessment.grad001.lettiezulu.service;

import com.enviro.assessment.grad001.lettiezulu.exception.ResourceNotFoundException;
import com.enviro.assessment.grad001.lettiezulu.model.WasteCategory;
import com.enviro.assessment.grad001.lettiezulu.repository.WasteCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WasteCategoryService {
    @Autowired
    private WasteCategoryRepository repository;

    public List<WasteCategory> getAllCategories() {
        return repository.findAll();
    }

    public WasteCategory getCategoryById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Category not found"));
    }

    public WasteCategory createCategory(WasteCategory category) {
        return repository.save(category);
    }

    public WasteCategory updateCategory(Long id, WasteCategory categoryDetails) {
        WasteCategory category = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Category not found"));

        category.setName(categoryDetails.getName());
        return repository.save(category);
    }

    public void deleteCategory(Long id) {
        WasteCategory category = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Category not found"));
        repository.delete(category);
    }
}

