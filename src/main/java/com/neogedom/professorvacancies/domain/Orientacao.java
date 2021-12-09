package com.neogedom.professorvacancies.domain;

import com.neogedom.professorvacancies.domain.enums.Tipo;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.ArrayList;
import java.util.List;

@Document @Data @NoArgsConstructor
public class Orientacao {
    @Id private String id;
    @Field @NonNull private Tipo tipo;
    @NonNull private Periodo periodoInscricao;
    @NonNull private Professor professor;
    private List<Aluno> alunos = new ArrayList<>();

    public Orientacao(String id, @NonNull Tipo tipo, @NonNull Periodo periodoInscricao, @NonNull Professor professor) {
        this.id = id;
        this.tipo = tipo;
        this.periodoInscricao = periodoInscricao;
        this.professor = professor;
    }
}
