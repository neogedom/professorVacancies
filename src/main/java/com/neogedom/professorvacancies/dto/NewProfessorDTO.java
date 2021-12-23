package com.neogedom.professorvacancies.dto;


import com.neogedom.professorvacancies.domain.Interesse;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Getter @Setter @NoArgsConstructor
public class NewProfessorDTO {
    private String id;
    @NotEmpty(message = "Preenchimento obrigatório")
    @Length(min = 3, max = 80, message = "O tamanho do nome deve ter entre 3 e 80 caracteres")
    private String nome;
    @Email(message = "Este e-mail não está no formato correto") @NotEmpty(message = "Preenchimento obrigatório")
    private String email;
    @NotEmpty(message = "Preenchimento obrigatório")
    private String senha;
    private List<Interesse> interesseDePesquisa;

}
