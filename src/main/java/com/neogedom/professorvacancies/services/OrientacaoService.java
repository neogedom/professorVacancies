package com.neogedom.professorvacancies.services;

import com.neogedom.professorvacancies.domain.Orientacao;
import com.neogedom.professorvacancies.domain.Professor;
import com.neogedom.professorvacancies.dto.NewOrientacaoDTO;
import com.neogedom.professorvacancies.dto.OrientacaoDTO;
import com.neogedom.professorvacancies.repository.AlunoRepository;
import com.neogedom.professorvacancies.repository.OrientacaoRepository;
import com.neogedom.professorvacancies.repository.ProfessorRepository;
import com.neogedom.professorvacancies.services.exceptions.*;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrientacaoService {

    private final OrientacaoRepository orientacaoRepository;
    private final ProfessorRepository professorRepository;
    private final AlunoRepository alunoRepository;
    private final AlunoService alunoService;
    private final ProfessorService professorService;

    public OrientacaoService(OrientacaoRepository orientacaoRepository,
                             ProfessorRepository professorRepository,
                             AlunoRepository alunoRepository,
                             AlunoService alunoService,
                             ProfessorService professorService) {
        this.orientacaoRepository = orientacaoRepository;
        this.professorRepository = professorRepository;
        this.alunoRepository = alunoRepository;
        this.alunoService = alunoService;
        this.professorService = professorService;
    }

    public List<Orientacao> getAllByProfessor() {
        var professor = professorService.authenticated();
        if(professor == null) {
            throw new AuthorizationException("Acesso negado!");
        }
        return professor.getOrientacoes();
    }

    public Orientacao getById(String id) {
        return orientacaoRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Objeto n??o encontrado! Id: " +
                        id + " Tipo: " + Orientacao.class.getName()));
    }

    @Transactional
    public Orientacao create (@NotNull Orientacao orientacao) {
        var idProfessor = professorService.authenticated().getId();
        var professor = professorRepository.findById(idProfessor)
                .orElseThrow(() -> new ObjectNotFoundException("Objeto n??o encontrado! Id: " +
                        idProfessor + " Tipo: " + Professor.class.getName()));
        var savedOrientacao = orientacaoRepository.save(orientacao);
        professor.getOrientacoes().add(savedOrientacao);
        professorRepository.save(professor);
        return orientacaoRepository.save(orientacao);
    }

    @Transactional
    public Orientacao subscribe(OrientacaoDTO orientacaoDTO) {

        if (orientacaoDTO.getId().equals("") || orientacaoDTO.getId().isBlank())
        {
            throw new MissingPropertyException("Id n??o pode ser vazio nesta opera????o!");
        }

        var orientacao = getById(orientacaoDTO.getId());
        if (orientacao.getVagas() > 0) {
            var aluno = alunoService.authenticated();
             if (getById(orientacaoDTO.getId()).getInscritos().contains(aluno)){
                 throw new AlreadySubscriptedException("Voc?? j?? est?? inscrito nessa orienta????o");
             }
            orientacao.getInscritos().add(aluno);

            orientacaoRepository.save(orientacao);
            alunoRepository.save(aluno);
        } else {
             throw new NoVacanciesException("Quantidade insuficiente de vagas");
        }
        return orientacao;
    }

    public Orientacao fromDTO(NewOrientacaoDTO orientacaoDTO) {
        return new Orientacao(orientacaoDTO.getId(), orientacaoDTO.getTipo(), orientacaoDTO.getDataInicial(), orientacaoDTO.getDataFinal(), orientacaoDTO.getVagas());
    }



}
