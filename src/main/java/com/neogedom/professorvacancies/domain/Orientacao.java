package com.neogedom.professorvacancies.domain;

import com.neogedom.professorvacancies.domain.enums.Tipo;
import com.neogedom.professorvacancies.dto.PeriodoDTO;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.ArrayList;
import java.util.List;

@Document @Data @NoArgsConstructor
public class Orientacao {
    @Id private String id;
    @Field @NonNull private Tipo tipo;
    @NonNull private PeriodoDTO periodoInscricao;
    @NonNull private Professor professor;
    @NonNull private Integer vagas;
    private List<Aluno> alunos = new ArrayList<>();

    public Orientacao(String id, @NotNull Tipo tipo, @NotNull PeriodoDTO periodoInscricao,
                      @NotNull Professor professor, @NonNull Integer vagas) {
        this.id = id;
        this.tipo = tipo;
        this.periodoInscricao = periodoInscricao;
        this.professor = professor;
        this.vagas = vagas;
    }
}
