package com.neogedom.professorvacancies.dto;

import lombok.*;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class PeriodoDTO {
    @NotEmpty(message = "Preenchimento obrigatório")
    private LocalDate dataInicial;
    @Future @NotEmpty(message = "Preenchimento obrigatório")
    private LocalDate dataFinal;
}
