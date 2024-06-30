package com.enviro.assessment.grad001.lettiezulu.service;


import com.enviro.assessment.grad001.lettiezulu.model.RecyclingTip;
import com.enviro.assessment.grad001.lettiezulu.repository.RecyclingTipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecyclingTipService {

    @Autowired
    private RecyclingTipRepository repository;

    public List<RecyclingTip> findAll() {
        return repository.findAll();
    }

    public Optional<RecyclingTip> findById(Long id) {
        return repository.findById(id);
    }

    public RecyclingTip save(RecyclingTip tip) {
        return repository.save(tip);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}