package com.neogedom.professorvacancies.dto;

import com.neogedom.professorvacancies.domain.Aluno;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.jetbrains.annotations.NotNull;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Getter @Setter @NoArgsConstructor
public class NewAlunoDTO {
    private String id;
    @NotEmpty(message = "Preenchimento obrigatório")
    @Length(min = 3, max = 80, message = "O tamanho do nome deve ter entre 3 e 80 caracteres")
    private String nome;
    @Email(message = "Este e-mail não está no formato correto") @NotEmpty(message = "Preenchimento obrigatório")
    private String email;
    @NotEmpty(message = "Preenchimento obrigatório")
    // @Pattern(regexp = "\"^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{4,}$\"", message = "A senha deve possuir pelo menos 4 caracteres, com pelo menos 1 letra e 1 número")
    private String senha;
    private String telefone;

}
