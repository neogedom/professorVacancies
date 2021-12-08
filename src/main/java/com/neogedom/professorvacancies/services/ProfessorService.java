package com.neogedom.professorvacancies.services;

import com.neogedom.professorvacancies.domain.Professor;
import com.neogedom.professorvacancies.dto.ProfessorDTO;
import com.neogedom.professorvacancies.repository.ProfessorRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

@Service
public class ProfessorService {

    private final ProfessorRepository repo;

    public ProfessorService(ProfessorRepository repo) {
        this.repo = repo;
    }

    public Professor create (Professor professor) {
        return repo.save(professor);
    }

    public Professor fromDTO (@NotNull ProfessorDTO professorDTO) {
        return new Professor(professorDTO.getId(), professorDTO.getNome(), professorDTO.getInteresseDePesquisa());

    }
}
