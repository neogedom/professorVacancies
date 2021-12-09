package com.neogedom.professorvacancies.dto;

import lombok.*;

import java.time.LocalDate;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class PeriodoDTO {
    private LocalDate dataInicial;
    private LocalDate dataFinal;
}
