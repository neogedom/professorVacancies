package com.neogedom.professorvacancies.dto;

import com.neogedom.professorvacancies.domain.Orientacao;
import com.neogedom.professorvacancies.domain.enums.Tipo;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Data @NoArgsConstructor
public class OrientacaoDTO {

    private String id;
    @Field private Tipo tipo;
    @PastOrPresent(message = "A data inicial deve ser menor ou igual à de hoje")
    private LocalDate dataInicial;
    @FutureOrPresent(message = "A data final deve maior ou igual à de hoje")
    private LocalDate dataFinal;
    private String professor;
    @Positive(message = "A quantidade de vagas deve ser maior que uma")
    private Integer vagas;

    public OrientacaoDTO (@NotNull Orientacao orientacao) {
        this.id = orientacao.getId();
        this.tipo = orientacao.getTipo();
        this.dataInicial = orientacao.getPeriodoInscricao().getDataInicial();
        this.dataFinal = orientacao.getPeriodoInscricao().getDataInicial();
        this.professor = orientacao.getProfessor().getId();
        this.vagas = orientacao.getVagas();
    }
}
