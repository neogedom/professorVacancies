package com.neogedom.professorvacancies.dto;


import com.neogedom.professorvacancies.domain.Interesse;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.List;

@Getter @Setter @NoArgsConstructor
public class NewProfessorDTO {
    private String id;
    @NotEmpty(message = "Preenchimento obrigatório")
    @Length(min = 3, max = 80, message = "O tamanho do nome deve ter entre 3 e 80 caracteres")
    private String nome;
    @Pattern(regexp = "(^| )([a-z]+\\.[a-z]+)(@ifms\\.edu\\.br)($| )", message = "Apenas e-mails instituicionais são permitidos") @NotEmpty(message = "Preenchimento obrigatório")
    @NotEmpty(message = "Preenchimento obrigatório")
    private String email;
    @NotEmpty @Pattern(regexp = "^\\S*(?=\\S{6,})(?=\\S*\\d)(?=\\S*[A-Z])(?=\\S*[a-z])(?=\\S*[!@#$%^&*? ])\\S*$", message = "A senha deve possuir pelo menos 6 caracteres, com pelo menos 1 letra, 1 número e 1 símbolo")
    private String senha;
    private List<Interesse> interesseDePesquisa;

}
