package com.neogedom.professorvacancies.dto;

import com.neogedom.professorvacancies.domain.Orientacao;
import com.neogedom.professorvacancies.domain.enums.Tipo;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;

@Data @NoArgsConstructor
public class OrientacaoDTO {

    private String id;
    private Tipo tipo;
    private LocalDate dataInicial;
    private LocalDate dataFinal;
    private Integer vagas;
    private Integer qtdeInscritos;

    public OrientacaoDTO (@NotNull Orientacao orientacao) {
        this.id = orientacao.getId();
        this.tipo = orientacao.getTipo();
        this.dataInicial = orientacao.getPeriodoInscricao().getDataInicial();
        this.dataFinal = orientacao.getPeriodoInscricao().getDataInicial();
        this.vagas = orientacao.getVagas();
        this.qtdeInscritos = orientacao.getInscritos().size();
    }
}
