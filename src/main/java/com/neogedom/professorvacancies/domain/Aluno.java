package com.neogedom.professorvacancies.domain;

import com.neogedom.professorvacancies.domain.enums.Perfil;
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
public class Aluno extends Usuario {
    @NonNull private String nome;
    @NonNull private String telefone;

    public Aluno(String id, @NonNull String nome, @NonNull String telefone,
    @NotNull String email, @NotNull String senha) {
        super(id, email, senha);
        this.nome = nome;
        this.telefone = telefone;
        addPerfil(Perfil.ROLE_ALUNO);
    }
}
