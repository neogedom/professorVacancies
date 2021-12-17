package com.neogedom.professorvacancies.dto;

import com.neogedom.professorvacancies.domain.Orientacao;
import com.neogedom.professorvacancies.domain.enums.Tipo;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.mongodb.core.mapping.Field;

@Data @NoArgsConstructor
public class OrientacaoDTO {

    private String id;
    @Field private Tipo tipo;
    private PeriodoDTO periodoInscricao;
    private String professor;
    private Integer vagas;

    public OrientacaoDTO (@NotNull Orientacao orientacao) {
        this.id = orientacao.getId();
        this.tipo = orientacao.getTipo();
        this.periodoInscricao = orientacao.getPeriodoInscricao();
        this.professor = orientacao.getProfessor().getId();
        this.vagas = orientacao.getVagas();
    }
}
