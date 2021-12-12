package com.neogedom.professorvacancies.domain;

import lombok.*;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Document(collection = "usuario") @Data @NoArgsConstructor
public class Aluno extends Usuario {
    @NonNull private String nome;
    @NonNull private String telefone;
    private List<Orientacao> orientacoes = new ArrayList<>();

    public Aluno(String id, @NonNull String nome, @NonNull String telefone,
    @NotNull String email, @NotNull String senha) {
        super(id, email, senha);
        this.nome = nome;
        this.telefone = telefone;
    }
}
