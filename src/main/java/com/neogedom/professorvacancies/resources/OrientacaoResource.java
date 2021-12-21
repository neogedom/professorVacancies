package com.neogedom.professorvacancies.resources;

import com.neogedom.professorvacancies.dto.OrientacaoDTO;
import com.neogedom.professorvacancies.services.OrientacaoService;
import com.neogedom.professorvacancies.services.ProfessorService;
import lombok.NonNull;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/orientacao")
public class OrientacaoResource {

    final OrientacaoService orientacaoService;
    final ProfessorService professorService;

    public OrientacaoResource(@NotNull OrientacaoService orientacaoService,
                              @NotNull ProfessorService professorService) {
        this.orientacaoService = orientacaoService;
        this.professorService = professorService;
    }

    @PreAuthorize("hasAnyRole('PROFESSOR')")
    @PostMapping
    public ResponseEntity<OrientacaoDTO> create (@RequestBody OrientacaoDTO orientacaoDTO) {
        orientacaoDTO.setProfessor(professorService.authenticated().getId());
        var orientacao = orientacaoService.fromDTO(orientacaoDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new OrientacaoDTO(orientacaoService.create(orientacao)));
    }

    @GetMapping
    public ResponseEntity<List<OrientacaoDTO>> getAll () {
        var list = orientacaoService.getAll().stream()
                .map(OrientacaoDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok(list);
    }

    @PreAuthorize("hasAnyRole('ALUNO')")
    @PutMapping(value = "/subscribe")
    public ResponseEntity<OrientacaoDTO> subscribe (@RequestBody OrientacaoDTO orientacaoDTO) {
        return ResponseEntity.status(HttpStatus.NO_CONTENT)
                .body(new OrientacaoDTO(orientacaoService.subscribe(orientacaoDTO)));
    }
}
