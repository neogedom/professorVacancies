package com.neogedom.professorvacancies.dto;

import com.neogedom.professorvacancies.domain.Orientacao;
import com.neogedom.professorvacancies.domain.Periodo;
import com.neogedom.professorvacancies.domain.enums.Tipo;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.mongodb.core.mapping.Field;

@Data @NoArgsConstructor
public class OrientacaoDTO {

    private String id;
    @Field
    private Tipo tipo;
    private Periodo periodoInscricao;
    private String professor;

    public OrientacaoDTO (@NotNull Orientacao orientacao) {
        this.id = orientacao.getId();
        this.tipo = orientacao.getTipo();
        this.periodoInscricao = orientacao.getPeriodoInscricao();
        this.professor = orientacao.getProfessor().getId();
    }
}
