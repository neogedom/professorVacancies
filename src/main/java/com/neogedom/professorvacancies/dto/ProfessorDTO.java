package com.neogedom.professorvacancies.dto;


import com.neogedom.professorvacancies.domain.Professor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

@Data @NoArgsConstructor
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
