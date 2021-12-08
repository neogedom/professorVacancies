package com.neogedom.professorvacancies.dto;


import com.neogedom.professorvacancies.domain.Professor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

@Getter @Setter @NoArgsConstructor
public class ProfessorDTO {
    private String id;
    private String nome;
    private String interesseDePesquisa;

    public ProfessorDTO (@NotNull Professor professor) {
        this.id = professor.getId();
        this.nome = professor.getNome();
        this.interesseDePesquisa = professor.getInteresseDePesquisa();
    }

}
