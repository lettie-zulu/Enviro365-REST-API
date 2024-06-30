package com.enviro.assessment.grad001.lettiezulu.service;


import com.enviro.assessment.grad001.lettiezulu.model.DisposalGuideline;
import com.enviro.assessment.grad001.lettiezulu.repository.DisposalGuidelineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DisposalGuidelineService {

    @Autowired
    private DisposalGuidelineRepository repository;

    public List<DisposalGuideline> findAll() {
        return repository.findAll();
    }

    public Optional<DisposalGuideline> findById(Long id) {
        return repository.findById(id);
    }

    public DisposalGuideline save(DisposalGuideline guideline) {
        return repository.save(guideline);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}


