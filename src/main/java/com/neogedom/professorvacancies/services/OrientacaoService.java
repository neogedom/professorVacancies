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

    public Orientacao getById(@NotNull String id) {
        return orientacaoRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " +
                        id + "Tipo: " + Orientacao.class.getName()));
    }

    public Orientacao create (@NotNull Orientacao orientacao) {
        var professor =  professorRepository.findById(orientacao.getProfessor().getId())
                .orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " +
                        orientacao.getProfessor().getId() + "Tipo: " + Professor.class.getName()));
        orientacao.setProfessor(professor);
        return orientacaoRepository.save(orientacao);
    }

    // inscrição ->
    // verifica se ainda tem vaga (possivelmente usando mutex)
    // insere aluno na lista de alunos (inscritos) da orientação,
    // pega usuário logado, testa se é aluno, insere aluno na lista
    // insere orientação na lista de orientações do aluno
    // altera quantidade de vagas,


//    public Orientacao subscribe(@NotNull String id, @NotNull Orientacao orientacaoDTO) {
//        var orientacao = getById(orientacaoDTO.getId());
//        if (orientacao.getVagas() > 0) {
////            orientacao.getInscritos().add(aluno);
//            orientacao.setVagas(orientacao.getVagas() - 1);
//        }
//        return null;
//    }

    public Orientacao fromDTO(@NotNull OrientacaoDTO orientacaoDTO) {
        var professor =  professorRepository.findById(orientacaoDTO.getProfessor())
                .orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " +
                        orientacaoDTO.getProfessor() + "Tipo: " + Professor.class.getName()));
        return new Orientacao(orientacaoDTO.getId(), orientacaoDTO.getTipo(), orientacaoDTO.getPeriodoInscricao(), professor, orientacaoDTO.getVagas());
    }


}
