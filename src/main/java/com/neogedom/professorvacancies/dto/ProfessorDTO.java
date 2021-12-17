package com.neogedom.professorvacancies.dto;


import com.neogedom.professorvacancies.domain.Interesse;
import com.neogedom.professorvacancies.domain.Professor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import java.util.List;

@Getter @Setter @NoArgsConstructor
public class ProfessorDTO {
    private String id;
    private String nome;
    private String email;
    private List<Interesse> interessesDePesquisa;

    public ProfessorDTO(@NotNull Professor professor) {
        this.id = professor.getId();
        this.nome = professor.getNome();
        this.email = professor.getEmail();
        this.interessesDePesquisa = professor.getInteressesDePesquisa();
    }
}
