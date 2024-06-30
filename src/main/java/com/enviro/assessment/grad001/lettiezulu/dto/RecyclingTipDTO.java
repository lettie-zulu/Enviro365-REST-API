package com.enviro.assessment.grad001.lettiezulu.dto;

import lombok.Getter;
import lombok.Setter;

import jakarta.validation.constraints.NotNull;

@Getter
@Setter
public class RecyclingTipDTO {
    @NotNull
    private String tip;
}
