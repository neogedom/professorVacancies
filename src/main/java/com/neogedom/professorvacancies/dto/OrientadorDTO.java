package com.neogedom.professorvacancies.dto;


import com.neogedom.professorvacancies.domain.Professor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter @Setter @NoArgsConstructor
public class OrientadorDTO {
    private String id;
    private String nome;
    private List<OrientacaoDTO> orientacoes = new ArrayList<>();

    public OrientadorDTO(@NotNull Professor professor) {
        this.id = professor.getId();
        this.nome = professor.getNome();
        this.orientacoes = professor.getOrientacoes().stream().map(OrientacaoDTO::new).collect(Collectors.toList());
    }
}
