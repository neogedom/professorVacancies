package com.neogedom.professorvacancies.services;

import com.neogedom.professorvacancies.domain.Professor;
import com.neogedom.professorvacancies.dto.NewProfessorDTO;
import com.neogedom.professorvacancies.repository.ProfessorRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ProfessorService {

    private final ProfessorRepository repo;
    private final BCryptPasswordEncoder pe;

    public ProfessorService(ProfessorRepository repo, BCryptPasswordEncoder pe) {
        this.repo = repo;
        this.pe = pe;
    }

    public Professor create (Professor professor) {
        return repo.save(professor);
    }

    public Professor fromDTO (@NotNull NewProfessorDTO newProfessorDTO) {
        return new Professor(newProfessorDTO.getId(), newProfessorDTO.getNome(), newProfessorDTO.getInteresseDePesquisa(), newProfessorDTO.getEmail(), pe.encode(newProfessorDTO.getSenha()));
    }
}
