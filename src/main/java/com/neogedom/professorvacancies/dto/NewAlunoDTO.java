package com.neogedom.professorvacancies.dto;

import com.neogedom.professorvacancies.domain.Aluno;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

@Getter @Setter @NoArgsConstructor
public class NewAlunoDTO {
    private String id;
    private String nome;
    private String email;
    private String senha;
    private String telefone;

    public NewAlunoDTO(@NotNull Aluno aluno) {
        this.id = aluno.getId();
        this.nome = aluno.getNome();
        this.email = aluno.getEmail();
        this.senha = aluno.getSenha();
        this.telefone = aluno.getTelefone();
    }
}
