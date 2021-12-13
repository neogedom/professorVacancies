package com.neogedom.professorvacancies.domain;

import com.neogedom.professorvacancies.domain.enums.Perfil;
import lombok.*;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Document(collection = "usuario") @Data @NoArgsConstructor
public class Aluno extends Usuario {
    @NonNull private String nome;
    @NonNull private String telefone;
    private List<Orientacao> orientacoes = new ArrayList<>();
    private Set<Perfil> perfis = new HashSet<>();

    public Aluno(String id, @NonNull String nome, @NonNull String telefone,
    @NotNull String email, @NotNull String senha) {
        super(id, email, senha);
        this.nome = nome;
        this.telefone = telefone;
        addPerfil(Perfil.ROLE_ALUNO);
    }

    public void addPerfil(Perfil perfil) {
        perfis.add(perfil);
    }
}
