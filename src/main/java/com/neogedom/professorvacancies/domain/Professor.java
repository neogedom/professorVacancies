package com.neogedom.professorvacancies.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Document(collection = "usuario") @Data @NoArgsConstructor
public class Professor extends Usuario {
    @NonNull private String nome;
    @NonNull private String interesseDePesquisa;
    private List<Orientacao> orientacoes = new ArrayList<>();

    public Professor (String id, @NotNull String nome, @NotNull String interesseDePesquisa,
    @NotNull String email, @NotNull String senha) {
        super(id, email, senha);
        this.nome = nome;
        this.interesseDePesquisa = interesseDePesquisa;
    }
}
