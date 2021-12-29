package com.neogedom.professorvacancies.services;

import com.neogedom.professorvacancies.domain.Orientacao;
import com.neogedom.professorvacancies.domain.Professor;
import com.neogedom.professorvacancies.dto.NewOrientacaoDTO;
import com.neogedom.professorvacancies.dto.OrientacaoDTO;
import com.neogedom.professorvacancies.repository.OrientacaoRepository;
import com.neogedom.professorvacancies.repository.ProfessorRepository;
import com.neogedom.professorvacancies.services.exceptions.*;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrientacaoService {

    private final OrientacaoRepository orientacaoRepository;
    private final ProfessorRepository professorRepository;
    private final AlunoService alunoService;
    private final ProfessorService professorService;

    public OrientacaoService(OrientacaoRepository orientacaoRepository,
                             ProfessorRepository professorRepository,
                             AlunoService alunoService,
                             ProfessorService professorService) {
        this.orientacaoRepository = orientacaoRepository;
        this.professorRepository = professorRepository;
        this.alunoService = alunoService;
        this.professorService = professorService;
    }

    public List<Orientacao> getAll() {
        var aluno = alunoService.authenticated();
        if(aluno == null) {
            throw new AuthorizationException("Acesso negado!");
        }
        return orientacaoRepository.findAll();
    }

    public List<Orientacao> getAllByProfessor() {
        var professor = professorService.authenticated();
        if(professor == null) {
            throw new AuthorizationException("Acesso negado!");
        }
        return orientacaoRepository.findAllByProfessor(professor);
    }

    public Orientacao getById(String id) {
        return orientacaoRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " +
                        id + " Tipo: " + Orientacao.class.getName()));
    }

    public Orientacao create (@NotNull Orientacao orientacao) {
        var professor =  professorRepository.findById(orientacao.getProfessor().getId())
                .orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " +
                        orientacao.getProfessor().getId() + " Tipo: " + Professor.class.getName()));
        orientacao.setProfessor(professor);
        return orientacaoRepository.save(orientacao);
    }

    public Orientacao subscribe(OrientacaoDTO orientacaoDTO) {

        if (orientacaoDTO.getId().equals("") || orientacaoDTO.getId().isBlank())
        {
            throw new MissingPropertyException("Id não pode ser vazio nesta operação!");
        }

        var orientacao = getById(orientacaoDTO.getId());
        if (orientacao.getVagas() > 0) {
            var aluno = alunoService.authenticated();
             if (getById(orientacaoDTO.getId()).getInscritos().contains(aluno)){
                 throw new AlreadySubscriptedException("Você já está inscrito nessa orientação");
             }
            orientacao.getInscritos().add(aluno);
            orientacaoRepository.save(orientacao);
        } else {
             throw new NoVacanciesException("Quantidade insuficiente de vagas");
        }
        return orientacao;
    }

    public Orientacao fromDTO(NewOrientacaoDTO orientacaoDTO) {
        var professor =  professorRepository.findById(orientacaoDTO.getProfessor())
                .orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " +
                        orientacaoDTO.getProfessor() + " Tipo: " + Professor.class.getName()));
        return new Orientacao(orientacaoDTO.getId(), orientacaoDTO.getTipo(), orientacaoDTO.getDataInicial(), orientacaoDTO.getDataFinal(), professor, orientacaoDTO.getVagas());
    }



}
