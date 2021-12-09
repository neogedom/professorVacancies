package com.neogedom.professorvacancies.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document @Data @NoArgsConstructor
public class Professor {
    @Id private String id;
    @NonNull private String nome;
    @NonNull private String interesseDePesquisa;
    private Orientacao orientacao;

    public Professor (String id, @NotNull String nome, @NotNull String interesseDePesquisa) {
        this.id = id;
        this.nome = nome;
        this.interesseDePesquisa = interesseDePesquisa;
    }
}
