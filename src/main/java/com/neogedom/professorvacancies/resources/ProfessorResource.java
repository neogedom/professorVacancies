package com.neogedom.professorvacancies.resources;

import com.neogedom.professorvacancies.domain.Professor;
import com.neogedom.professorvacancies.dto.AlunoDTO;
import com.neogedom.professorvacancies.dto.NewProfessorDTO;
import com.neogedom.professorvacancies.dto.ProfessorDTO;
import com.neogedom.professorvacancies.services.ProfessorService;
import lombok.NonNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/professor")
public class ProfessorResource {

    @NonNull final ProfessorService professorService;

    public ProfessorResource(@NonNull ProfessorService professorService) {
        this.professorService = professorService;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ProfessorDTO> getById(@PathVariable String id) {
        return ResponseEntity.ok().body(new ProfessorDTO(professorService.getSelf(id)));
    }

    @PostMapping
    public ResponseEntity<ProfessorDTO> create (@Valid @RequestBody NewProfessorDTO newProfessorDTO) {
        Professor professor = professorService.fromDTO(newProfessorDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ProfessorDTO(professorService.create(professor)));
    }

}
