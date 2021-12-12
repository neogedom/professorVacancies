package com.neogedom.professorvacancies.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "usuario") @Data @NoArgsConstructor
public class Usuario {
    @Id private String id;
    @NonNull private String email;
    @NonNull private String senha;

    public Usuario (String id, @NotNull String email, @NotNull String senha) {
        this.id = id;
        this.email = email;
        this.senha = senha;
    }
}
