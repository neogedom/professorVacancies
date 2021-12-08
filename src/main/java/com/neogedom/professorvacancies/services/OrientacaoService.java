package com.neogedom.professorvacancies.services;

import com.neogedom.professorvacancies.domain.Orientacao;
import com.neogedom.professorvacancies.domain.Professor;
import com.neogedom.professorvacancies.dto.OrientacaoDTO;
import com.neogedom.professorvacancies.repository.OrientacaoRepository;
import com.neogedom.professorvacancies.repository.ProfessorRepository;
import com.neogedom.professorvacancies.services.exceptions.ObjectNotFoundException;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

@Service
public class OrientacaoService {

    private final OrientacaoRepository orientacaoRepository;
    private final ProfessorRepository professorRepository;

    public OrientacaoService(OrientacaoRepository orientacaoRepository,
                             ProfessorRepository professorRepository) {
        this.orientacaoRepository = orientacaoRepository;
        this.professorRepository = professorRepository;
    }

    public Orientacao create (@NotNull Orientacao orientacao) {
        var professor =  professorRepository.findById(orientacao.getProfessor().getId())
                .orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " +
                        orientacao.getProfessor().getId() + "Tipo: " + Professor.class.getName()));
        orientacao.setProfessor(professor);
        return orientacaoRepository.save(orientacao);
    }

    public Orientacao fromDTO(@NotNull OrientacaoDTO orientacaoDTO) {
        var professor =  professorRepository.findById(orientacaoDTO.getProfessor())
                .orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " +
                        orientacaoDTO.getProfessor() + "Tipo: " + Professor.class.getName()));
        return new Orientacao(orientacaoDTO.getId(), orientacaoDTO.getTipo(), orientacaoDTO.getPeriodoInscricao(), professor);
    }

}
