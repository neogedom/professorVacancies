package com.neogedom.professorvacancies.domain;

import com.neogedom.professorvacancies.domain.enums.Perfil;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashSet;
import java.util.Set;

@Document(collection = "usuario") @Data @NoArgsConstructor
public class Usuario {
    @Id private String id;
    @NonNull private String email;
    @NonNull private String senha;
    private Set<Perfil> perfis = new HashSet<>();

    public Usuario (String id, @NotNull String email, @NotNull String senha) {
        this.id = id;
        this.email = email;
        this.senha = senha;
    }

    public void addPerfil(Perfil perfil) {
        perfis.add(perfil);
    }
}
