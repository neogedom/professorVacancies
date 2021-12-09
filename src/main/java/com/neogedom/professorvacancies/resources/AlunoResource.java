package com.neogedom.professorvacancies.resources;

import com.neogedom.professorvacancies.domain.Aluno;
import com.neogedom.professorvacancies.dto.AlunoDTO;
import com.neogedom.professorvacancies.dto.ProfessorDTO;
import com.neogedom.professorvacancies.services.AlunoService;
import com.neogedom.professorvacancies.services.ProfessorService;
import lombok.NonNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/alunos")
public class AlunoResource {

    @NonNull final AlunoService alunoService;

    public AlunoResource(@NonNull AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @PostMapping
    public ResponseEntity<AlunoDTO> create (@RequestBody AlunoDTO alunoDTO) {
        Aluno aluno = alunoService.fromDTO(alunoDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new AlunoDTO(alunoService.create(aluno)));
    }

}
