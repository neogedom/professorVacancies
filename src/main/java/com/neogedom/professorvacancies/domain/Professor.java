package com.neogedom.professorvacancies.domain;

import com.neogedom.professorvacancies.domain.enums.Perfil;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Document(collection = "usuario") @Data
public class Professor extends Usuario {
    @NonNull private String nome;
    @NonNull private String interesseDePesquisa;
    private List<Orientacao> orientacoes = new ArrayList<>();
    private Set<Perfil> perfis = new HashSet<>();

    public Professor (String id, @NotNull String nome, @NotNull String interesseDePesquisa,
    @NotNull String email, @NotNull String senha) {
        super(id, email, senha);
        this.nome = nome;
        this.interesseDePesquisa = interesseDePesquisa;
        addPerfil(Perfil.ROLE_PROFESSOR);
    }

    public void addPerfil(Perfil perfil) {
        perfis.add(perfil);
    }
}
