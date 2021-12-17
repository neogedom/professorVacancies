package com.neogedom.professorvacancies.domain;

import com.neogedom.professorvacancies.domain.enums.Perfil;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Document(collection = "usuario") @Data
public class Professor extends Usuario {
    @NonNull private String nome;
    private List<Interesse> interessesDePesquisa;
    private List<Orientacao> orientacoes = new ArrayList<>();

    public Professor (String id, String nome, List<Interesse>
            interessesDePesquisa, String email, String senha) {
        super(id, email, senha);
        this.nome = nome;
        this.interessesDePesquisa = interessesDePesquisa;
        addPerfil(Perfil.ROLE_PROFESSOR);
    }

    public void addInteresse(Interesse interesse) {
        interessesDePesquisa.add(interesse);
    }


}
