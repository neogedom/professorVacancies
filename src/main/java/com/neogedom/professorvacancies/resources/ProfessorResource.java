package com.neogedom.professorvacancies.resources;

import com.neogedom.professorvacancies.domain.Professor;
import com.neogedom.professorvacancies.dto.ProfessorDTO;
import com.neogedom.professorvacancies.services.ProfessorService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/professor")
public class ProfessorResource {

    @NonNull final ProfessorService professorService;

    public ProfessorResource(@NonNull ProfessorService professorService) {
        this.professorService = professorService;
    }

    @PostMapping
    public ResponseEntity<ProfessorDTO> create (@RequestBody ProfessorDTO professorDTO) {
        Professor professor = professorService.fromDTO(professorDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ProfessorDTO(professorService.create(professor)));
    }

}
