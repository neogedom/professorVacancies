package com.neogedom.professorvacancies.domain;

import com.neogedom.professorvacancies.domain.enums.Perfil;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashSet;
import java.util.Set;

@Document(collection = "usuario") @Data @NoArgsConstructor
public class Usuario {
    @Id private String id;
    private String email;
    private String senha;
    private Set<Perfil> perfis = new HashSet<>();

    public Usuario (String id, String email, String senha) {
        this.id = id;
        this.email = email;
        this.senha = senha;
    }

    public void addPerfil(Perfil perfil) {
        perfis.add(perfil);
    }
}
