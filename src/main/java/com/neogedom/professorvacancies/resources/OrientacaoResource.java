package com.neogedom.professorvacancies.resources;

import com.neogedom.professorvacancies.dto.OrientacaoDTO;
import com.neogedom.professorvacancies.services.OrientacaoService;
import lombok.NonNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/orientacoes")
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

}
