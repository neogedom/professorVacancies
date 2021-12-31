package com.neogedom.professorvacancies.domain;

import com.neogedom.professorvacancies.domain.enums.Tipo;
import com.neogedom.professorvacancies.dto.PeriodoDTO;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Document @Data @NoArgsConstructor
public class Orientacao {
    @Id private String id;
    @Field @NonNull private Tipo tipo;
    @NonNull private PeriodoDTO periodoInscricao;
    @NonNull private Integer vagas;
    private Set<Aluno> inscritos = new HashSet<>();

    public Orientacao(String id, Tipo tipo, LocalDate dataInicial, LocalDate dataFinal, Integer vagas) {
        this.id = id;
        this.tipo = tipo;
        this.periodoInscricao = new PeriodoDTO(dataInicial, dataFinal);
        this.vagas = vagas;
    }
}
