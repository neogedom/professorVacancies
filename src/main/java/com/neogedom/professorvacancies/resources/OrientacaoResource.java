package com.neogedom.professorvacancies.resources;

import com.neogedom.professorvacancies.dto.OrientacaoDTO;
import com.neogedom.professorvacancies.services.OrientacaoService;
import lombok.NonNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/orientacao")
public class OrientacaoResource {

    @NonNull final OrientacaoService orientacaoService;

    public OrientacaoResource(@NonNull OrientacaoService
                                      orientacaoService) {
        this.orientacaoService = orientacaoService;
    }

    @PostMapping
    public ResponseEntity<OrientacaoDTO> create (@RequestBody OrientacaoDTO orientacaoDTO) {
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

    @PutMapping(value = "/subscribe")
    public ResponseEntity<OrientacaoDTO> subscribe (@RequestBody OrientacaoDTO orientacaoDTO) {
        return ResponseEntity.status(HttpStatus.NO_CONTENT)
                .body(new OrientacaoDTO(orientacaoService.subscribe(orientacaoDTO)));
    }
}
