package com.neogedom.professorvacancies.resources;

import com.neogedom.professorvacancies.domain.Aluno;
import com.neogedom.professorvacancies.dto.AlunoDTO;
import com.neogedom.professorvacancies.dto.NewAlunoDTO;
import com.neogedom.professorvacancies.services.AlunoService;
import lombok.NonNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/aluno")
public class AlunoResource {

    @NonNull final AlunoService alunoService;

    public AlunoResource(@NonNull AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<AlunoDTO> getById(@PathVariable String id) {
        return ResponseEntity.ok().body(new AlunoDTO(alunoService.getSelf(id)));
    }

    @PostMapping
    public ResponseEntity<AlunoDTO> create (@Valid @RequestBody NewAlunoDTO alunoDTO) {
        Aluno aluno = alunoService.fromDTO(alunoDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new AlunoDTO(alunoService.create(aluno)));
    }

}
