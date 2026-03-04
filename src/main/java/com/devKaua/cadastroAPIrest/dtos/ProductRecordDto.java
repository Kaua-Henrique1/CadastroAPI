package com.devKaua.cadastroAPIrest.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
//                             Nao pode passar vazio
public record ProductRecordDto(@NotBlank String name, @NotNull BigDecimal value) {

}
