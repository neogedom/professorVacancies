package com.neogedom.professorvacancies.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document @Data @NoArgsConstructor
public class Aluno {
    @Id private String id;
    @NonNull private String nome;
    @NonNull private String email;
    @NonNull private String telefone;
    private List<Orientacao> orientacoes = new ArrayList<>();

    public Aluno(String id, @NonNull String nome, @NonNull String email, @NonNull String telefone) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }
}
