package com.neogedom.professorvacancies.dto;

import com.neogedom.professorvacancies.domain.enums.Tipo;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;
import java.time.LocalDate;

@Data @NoArgsConstructor
public class NewOrientacaoDTO {

    private String id;
    private Tipo tipo;
    @PastOrPresent(message = "A data inicial deve ser menor ou igual à de hoje")
    private LocalDate dataInicial;
    @FutureOrPresent(message = "A data final deve maior ou igual à de hoje")
    private LocalDate dataFinal;
    private String professor;
    @Positive(message = "A quantidade de vagas deve ser maior que uma")
    private Integer vagas;

}
