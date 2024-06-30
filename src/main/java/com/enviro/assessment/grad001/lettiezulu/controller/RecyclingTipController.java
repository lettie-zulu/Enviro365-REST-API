package com.enviro.assessment.grad001.lettiezulu.controller;


import com.enviro.assessment.grad001.lettiezulu.model.RecyclingTip;
import com.enviro.assessment.grad001.lettiezulu.service.RecyclingTipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/recycling-tips")
public class RecyclingTipController {

    @Autowired
    private RecyclingTipService service;

    @GetMapping(produces = "application/json")
    public List<RecyclingTip> getAllRecyclingTips() {
        return service.findAll();
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<RecyclingTip> getRecyclingTipById(@PathVariable Long id) {
        Optional<RecyclingTip> tip = service.findById(id);
        return tip.map(ResponseEntity::ok)
                  .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<RecyclingTip> createRecyclingTip(@Valid @RequestBody RecyclingTip tip) {
        RecyclingTip savedTip = service.save(tip);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedTip);
    }

    @PutMapping(value = "/{id}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<RecyclingTip> updateRecyclingTip(@PathVariable Long id, @Valid @RequestBody RecyclingTip tip) {
        if (!service.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        tip.setId(id);
        RecyclingTip updatedTip = service.save(tip);
        return ResponseEntity.ok(updatedTip);
    }

    @DeleteMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<Void> deleteRecyclingTip(@PathVariable Long id) {
        if (!service.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
