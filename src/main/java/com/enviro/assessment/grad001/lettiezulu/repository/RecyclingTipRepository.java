package com.enviro.assessment.grad001.lettiezulu.repository;

import com.enviro.assessment.grad001.lettiezulu.model.RecyclingTip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecyclingTipRepository extends JpaRepository<RecyclingTip, Long> {
}
