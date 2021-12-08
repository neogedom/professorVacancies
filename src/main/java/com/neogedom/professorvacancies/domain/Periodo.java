package com.neogedom.professorvacancies.domain;

import lombok.*;

import java.time.LocalDate;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Periodo {
    private LocalDate dataInicial;
    private LocalDate dataFinal;
}
