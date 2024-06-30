package com.enviro.assessment.grad001.lettiezulu.controller;

import com.enviro.assessment.grad001.lettiezulu.model.WasteCategory;
import com.enviro.assessment.grad001.lettiezulu.service.WasteCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class WasteCategoryController {
    @Autowired
    private WasteCategoryService service;

    @GetMapping(produces = "application/json")
    public List<WasteCategory> getAllCategories() {
        return service.getAllCategories();
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<WasteCategory> getCategoryById(@PathVariable(value = "id") Long id) {
        WasteCategory category = service.getCategoryById(id);
        return ResponseEntity.ok().body(category);
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public WasteCategory createCategory(@Validated @RequestBody WasteCategory category) {
        return service.createCategory(category);
    }

    @PutMapping(value = "/{id}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<WasteCategory> updateCategory(@PathVariable(value = "id") Long id, @Validated @RequestBody WasteCategory categoryDetails) {
        WasteCategory updatedCategory = service.updateCategory(id, categoryDetails);
        return ResponseEntity.ok(updatedCategory);
    }

    @DeleteMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<Void> deleteCategory(@PathVariable(value = "id") Long id) {
        service.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }
}
