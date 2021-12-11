package com.neogedom.professorvacancies.resources;

import com.neogedom.professorvacancies.dto.OrientacaoDTO;
import com.neogedom.professorvacancies.services.OrientacaoService;
import com.neogedom.professorvacancies.services.exceptions.MissingPropertyException;
import lombok.NonNull;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

//    @PutMapping(value = "/aluno/{id}")
//    public ResponseEntity<OrientacaoDTO> subscribe (@PathVariable String id,
//                                                    @RequestBody @NotNull OrientacaoDTO orientacaoDTO) {
//        if (orientacaoDTO.getId().equals("") || orientacaoDTO.getId().isBlank())
//        {
//            throw new MissingPropertyException("Id não pode ser vazio nesta operação!");
//        }
//        var orientacao = orientacaoService.fromDTO(orientacaoDTO);
//        return ResponseEntity.status(HttpStatus.CREATED)
//                .body(new OrientacaoDTO(orientacaoService.subscribe(id, orientacao)));
//    }
}
